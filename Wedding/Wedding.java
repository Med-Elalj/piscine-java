import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Wedding {

    public static Map<String, String> createCouple(Set<String> first, Set<String> second) {
        List<String> firstList = new ArrayList<>(first);
        List<String> secondList = new ArrayList<>(second);

        Collections.shuffle(firstList);
        Collections.shuffle(secondList);

        int pairCount = Math.min(firstList.size(), secondList.size());

        Map<String, String> couples = new HashMap<>();

        for (int i = 0; i < pairCount; i++) {
            couples.put(firstList.get(i), secondList.get(i));
        }

        return couples;
    }

}
