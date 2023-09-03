import java.io.*;
import java.net.*;

public class MultiProcessServer {
    public static void main(String[] args) {
        int portNumber = 8080 // Change this to your desired port number
        
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                ProcessBuilder processBuilder = new ProcessBuilder("java", "ClientHandler");
                processBuilder.redirectErrorStream(true);
                Process clientProcess = processBuilder.start();

                redirectStream(clientSocket.getInputStream(), clientProcess.getOutputStream());
                redirectStream(clientProcess.getInputStream(), clientSocket.getOutputStream());
                
                clientProcess.waitFor();
                System.out.println("Client disconnected");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void redirectStream(InputStream input, OutputStream output) {
        new Thread(() -> {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                    output.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
