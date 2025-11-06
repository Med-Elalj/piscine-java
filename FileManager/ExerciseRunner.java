import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        FileManager.createFile("file.txt", "Lorem ipsum");
        System.out.println(FileManager.getContentFile("file.txt"));
        // FileManager.deleteFile("file.txt");
    }
}