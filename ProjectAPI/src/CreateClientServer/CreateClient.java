package CreateClientServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class CreateClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket("localhost", 1234)){ // Change Server host address and Port
            DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataIn = new DataInputStream(socket.getInputStream());

            while (true) {
                String request = scanner.nextLine();
                dataOut.writeUTF(request);
                if (request.equals("end")) break;
                System.out.println(dataIn.readUTF());
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
