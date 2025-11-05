
import java.io.*;

public class Capitalize {

    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length != 2) {
            return;
        }
        String fileIput = args[0];
        String fileOut = args[1];
        String contet = "";
        try (InputStream inputStream = new FileInputStream(fileIput)) {
            int data;
            byte[] buffer = new byte[4096];
            while ((data = inputStream.read(buffer)) != -1) {
                contet += new String(buffer);
            }
            inputStream.close();
        }
        contet = capitalize(contet);
        try (OutputStream inputStream = new FileOutputStream(fileOut)) {
            inputStream.write(contet.getBytes());
            inputStream.close();
        }
    }

    public static String capitalize(String s) {
        s = s.trim();
        String[] res = s.split(" ");
        String ret = "";
        for (int i = 0; i < res.length; i++) {
            if (res[i].isEmpty()) {
                continue;
            }
            System.out.println(res[i].substring(0,1));
            ret += res[i].substring(0, 1).toUpperCase() + res[i].substring(1, res[i].length()).toLowerCase() + " ";
        }
        return ret.trim();
    }
}
