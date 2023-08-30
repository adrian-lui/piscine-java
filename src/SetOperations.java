import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2) {
        // your code here
        Set<Integer> set3 = new HashSet<>(set1);
        set3.addAll(set2);
        return set3;
    }

    public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        // your code here
        Set<Integer> set3 = new HashSet<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                set3.add(num);
            }
        }
        return set3;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> unionSet = SetOperations.union(set1, set2);
        System.out.println(unionSet); // Expected Output: [1, 2, 3, 4]

        Set<Integer> intersectionSet = SetOperations.intersection(set1, set2);
        System.out.println(intersectionSet); // Expected Output: [2, 3]
    }
}