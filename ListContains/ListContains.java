import java.util.List;

public class ListContains {
    public static boolean containsValue(List<Integer> list, Integer value) {
        for (Integer item : list) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }
}