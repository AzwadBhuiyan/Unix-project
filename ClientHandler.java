import java.io.*;

public class ClientHandler {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter writer = new PrintWriter(System.out, true);

            String message;
            while ((message = reader.readLine()) != null) {
                writer.println("Server received: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
