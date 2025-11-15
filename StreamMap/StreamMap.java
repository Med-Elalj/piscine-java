import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        return s.filter(str -> str != null)
                .mapToInt(String::length)
                .sum();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        return s.filter(str -> str != null)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
    
    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        return s.filter(d -> d != null && d > 42)
                .map(Double::intValue)
                .collect(Collectors.toSet());
    }
}