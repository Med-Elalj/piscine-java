
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    public static void createFile(String fileName, String content) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        try (OutputStream inputStream = new FileOutputStream(file)) {
            inputStream.write(content.getBytes());
            inputStream.close();
        }
    }

    public static String getContentFile(String fileName) throws IOException {
        Path p = Paths.get(fileName);
        return Files.readString(p);
        
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
