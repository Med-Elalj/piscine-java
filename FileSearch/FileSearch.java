import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        File folder = new File("documents");
        return searchFileRecursive(folder,fileName);
    }

    private static String searchFileRecursive(File folder, String fileName) {
        if (folder == null || !folder.isDirectory()) {
            return null;
        }

        File[] files = folder.listFiles();
        for (int i = 0 ; i < files.length ; i++) {
            if (files[i].getName().equals(fileName)) {
                return files[i].getPath();
            }

            if (files[i].isDirectory()) {
                String result = searchFileRecursive(files[i], fileName);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}