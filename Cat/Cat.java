
import java.io.*;

public class Cat {

    public static void cat(String[] args) throws IOException {
        if (args == null ) {
            return;
        }
        for (String filename : args) {
            try (InputStream inputStream = new FileInputStream(filename)) {
                int data;
                byte[] buffer = new byte[4096];
                while ((data = inputStream.read(buffer)) != -1) {
                    System.out.write(buffer , 0 , data);
                }
                inputStream.close();

            }
        }
    }
}
