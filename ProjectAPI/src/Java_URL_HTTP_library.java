import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Java_URL_HTTP_library {

/** URL structure */
/** Creation */
public static void main(String[] args) throws IOException {
                          //protocol|.........authority...............|...........file............../
    URL url = new URL("https://smirnov:password@geekbrains.ru:443/courses?type=qa&level=super#1");
                                                                             //...search params../#anchor/
                                  //....UserInfo....|.....host....|port|path......................./
/** Unpasring */
    System.out.println("Authority: " + url.getAuthority());
    System.out.println("Protocol: " + url.getProtocol());
    System.out.println("Host: " +url.getHost());
    System.out.println("Port: " +url.getPort());
    System.out.println("File: " +url.getFile());
    System.out.println("Path: " +url.getPath());

/** JAVA built-in URL and HTTP Library */
    URL url1 = new URL("https","geekbrains.ru", 443, "/courses" ); // Constructor

    /** url.openStream - to read the input data thread*/
    InputStream dataIn = url1.openStream(); // Gets info from the URL by InputStream in dataIn
    BufferedReader readIn = new BufferedReader(new InputStreamReader(dataIn, "UTF-8")); // Reads data from dataIn
    String line;
    while ((line=readIn.readLine()) != null) {
        System.out.println(line);
    }
    readIn.close();

    /** url.openConnection - to read and write both threads input and output*/
    URLConnection urlConnection = url1.openConnection();
    InputStream dataIn1 = urlConnection.getInputStream();
    BufferedReader readIn1 = new BufferedReader(new InputStreamReader(dataIn1, "UTF-8")); // Reads data from dataIn
    PrintWriter printWriter = new PrintWriter("temp_file.html");
    String currentString;
    while ((currentString=readIn1.readLine()) != null) {
        printWriter.println(currentString);
    }
    printWriter.close();
    readIn1.close();

    /** url.httpUrlConnection - provides access to http features by casting url.openConnection to (HttpURLConnection) */
    HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();
    System.out.println(httpURLConnection.getResponseCode()); // Get response code
    System.out.println(httpURLConnection.getRequestMethod()); // Get request method

    Map<String, List<String>> headers = httpURLConnection.getHeaderFields(); // Creates Map

    for (String key: headers.keySet()) { //Through for each cycle prints keys and values to console
            System.out.println("Key: " + key + "Value: " + headers.get(key));
    }


}
}
