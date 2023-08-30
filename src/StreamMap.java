import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static Integer sumOfStringLength(Stream<String> s) {
        // your code here
        return s.collect(Collectors.joining()).length();
    }

    public static List<String> upperCaseAllString(Stream<String> s) {
        // your code here
        return s.map(val -> val.toUpperCase()).collect(Collectors.toList());
    }

    public static Set<Integer> uniqIntValuesGreaterThan42(Stream<Double> s) {
        // your code here
        Set<Integer> result = new HashSet<>();
        s.filter(val -> val >= 42).forEach(val -> result.add(val.intValue()));
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(StreamMap.sumOfStringLength(Stream.of("Bonjour", "le", "monde !")));
        System.out.println(StreamMap.upperCaseAllString(Stream.of("IL", "Fait", "beaU !!")));
        System.out.println(StreamMap.uniqIntValuesGreaterThan42(Stream.of(23.439, 42.34, 39194.4)));
    }
}