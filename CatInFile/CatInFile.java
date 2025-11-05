
import java.io.*;

public class CatInFile {

    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }
        byte[] data = System.in.readAllBytes();
        String file = args[0];
        try (OutputStream inputStream = new FileOutputStream(file)) {
            inputStream.write(data);
            inputStream.close();
        }

    }
}
