import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to your server's address
        int serverPort = 12345; // Change this to the server's port number
        
        try (
            Socket socket = new Socket(serverAddress, serverPort);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // Send a message to the server
            writer.println("Hello, Server!");

            // Receive and print the server's response
            String response = reader.readLine();
            System.out.println("Server response: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
