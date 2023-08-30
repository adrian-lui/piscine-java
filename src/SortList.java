import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortList {

    public static List<Integer> sort(List<Integer> list) {
        // your code here
        return list.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> sortReverse(List<Integer> list) {
        // your code here
        List<Integer> list2 = new ArrayList<>(list);
        Collections.sort(list2, Collections.reverseOrder());
        return list2;
    }
    public static void main(String[] args) {
        System.out.println(SortList.sort(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());
        System.out.println(SortList.sortReverse(List.of(15, 1, 14, 18, 14, 98, 54, -1, 12)).toString());
    }
}