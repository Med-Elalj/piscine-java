
public class StringConcat {

    public static String concat(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return null;
        }else if (s1 == null) {
            s1 = "";
        }else if (s2 == null) {
            s2 = "";
        }
        return s1 + s2;
    }
}
