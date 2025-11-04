
public class CleanExtract {

    public static String extract(String s) {
        System.out.println(s);
        String[] res = s.split("\\|");
        if (res.length <= 1) {
            return clean(s);
        }
        String finale = clean(res[0].trim());
        for (int i = 1; i < res.length; i++) {
            String r = res[i].trim();
            if (r.equals(".")) {
                finale += " ";
                continue;
            }
            if (r.startsWith(".")) {
                finale += clean(r);
            } else {
                String[] all = r.split(" ");
                for (String elem : all) {
                    if (elem.startsWith(".")) {
                        finale += clean(elem) + " ";
                    }
                }
            }
        }
        if (finale.startsWith(".")) {
            finale = finale.substring(1, s.length());

        }
        return finale.replace("  ", " ").trim();
    }

    static String clean(String s) {
        if (s.equals("...")) {
            return  " .";
        }
        if (s.endsWith(".")) {
           s = s.substring(0, s.length() - 1);
        }
        if (s.startsWith(".")) {
            s = s.substring(1, s.length());
        } 
        return s;
    }
}
