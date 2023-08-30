import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.lang.Character;
public class StreamCollect {
    public static Map<Character, List<String>> mapByFirstLetter(Stream<String> s) {
        // your code here
        Map<Character, List<String>> result = new HashMap<>();
        s.forEach(val -> {
            Character letter = Character.toUpperCase(val.charAt(0));
            if (result.containsKey(letter)) {
                result.get(letter).add(val);
            } else {
                List<String> list = new ArrayList<>();
                list.add(val);
                result.put(letter, list);
            }
        });
        return result;
    }

    public static Map<Integer, Optional<Integer>> getMaxByModulo4(Stream<Integer> s) {
        // your code here
        Map<Integer, Optional<Integer>> result = new HashMap<>();
        result.put(0, Optional.of(0));
        result.put(1, Optional.of(0));
        result.put(2, Optional.of(0));
        result.put(3, Optional.of(0));
        s.forEach(num -> {
            switch (num % 4) {
                case 0:
                    result.put(0, Optional.of(Math.max(num, result.get(0).orElse(num))));
                    break;
                case 1:
                    result.put(1, Optional.of(Math.max(num, result.get(1).orElse(num))));
                    break;
                case 2:
                    result.put(2, Optional.of(Math.max(num, result.get(2).orElse(num))));
                    break;
                case 3:
                    result.put(3, Optional.of(Math.max(num, result.get(3).orElse(num))));
                    break;
                default:
                    System.out.println("Not a number");
            }
        });
        return result;
    }

    public static String orderAndConcatWithSharp(Stream<String> s) {
        // your code here
        String result = s.sorted().collect(Collectors.joining(" # "));
        return "{" + result + "}";
    }

    public static void main(String[] args) {
        System.out.println(StreamCollect.mapByFirstLetter(Stream.of("Bonjour", "le", "monde !", "bonsoir")));
        System.out.println(StreamCollect.getMaxByModulo4(Stream.of(5, 12, 32, 4, 9, 17, 98, 424, 97, 5843, 48354)));
        System.out.println(StreamCollect.orderAndConcatWithSharp(Stream.of("Hello", "how are you ?", "where do you live ?", "Bordeaux")));
    }
}