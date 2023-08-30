import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        // your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> setList = coins.stream().sorted().collect(Collectors.toList());
        Collections.sort(setList, Collections.reverseOrder());
        for (Integer val : setList) {
            int num = amount / val;
            for (int i = 0; i < num; i++) {
                result.add(val);
            }
            amount = amount - num * val;
        }
        return result;
    }
}