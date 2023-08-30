import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findLastIndex(List<Integer> list, Integer value) {
        // your code here
        int result = list.lastIndexOf(value);
        return result == -1? null : result;
    }
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        // your code here
        int result = list.indexOf(value);
        return result == -1? null : result;
    }
    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        // your code here
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == value) {
                indexes.add(i);
            }
        }
        return indexes;
    }
    public static void main(String[] args) {
        System.out.println(ListSearchIndex.findLastIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 89));
        System.out.println(ListSearchIndex.findFirstIndex(List.of(9, 13, 89, 8, 23, 1, 0, 89), 890));
        System.out.println(ListSearchIndex.findAllIndexes(List.of(9, 13, 89, 8, 23, 1, 0, 89), 839).toString());
    }
}