import java.io.*;
import java.util.zip.GZIPOutputStream;

public class ChainingFilterStreamsExample {
    public static void main(String[] args) {
        // Define the source data
        String sourceData = "This is some data to be compressed and written to a file.";

        // Specify the file path for the output
        String outputPath = "compressed_output.txt.gz";

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(bufferedOutputStream);

            byte[] dataBytes = sourceData.getBytes();

            gzipOutputStream.write(dataBytes);

            gzipOutputStream.close();
            bufferedOutputStream.close();
            fileOutputStream.close();

            System.out.println("Data has been compressed and written to " + outputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
