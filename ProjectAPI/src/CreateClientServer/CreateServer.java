package CreateClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

public class CreateServer {
    public static void main(String[] args) {
        Date date = new Date();
        try (ServerSocket serverSocket = new ServerSocket(1234)){  // Change port
            System.out.println("Server starts at: " + date.toString());
            Socket socket = serverSocket.accept(); // Opens server to receive data
            System.out.println("Connection established at port: " +serverSocket.getLocalPort()+ "at: " + date.toString());
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream()); // Open Stream to send data
            DataInputStream dataIn = new DataInputStream(socket.getInputStream()); // Open Stream to receive data

            while (true) {
                String clientRequest = dataIn.readUTF();
                if (clientRequest.equals("end")) break;
                System.out.println("Request from Client: " + clientRequest);
                dataOut.writeUTF("Response from server: " + clientRequest);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
