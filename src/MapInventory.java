import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MapInventory {
    public static int getProductPrice(Map<String, Integer> inventory, String productId) {
        // your code here
        if (inventory.get(productId) == null) {
            return -1;
        }
        return inventory.get(productId);
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {
        // your code here
        List<String> list = new ArrayList<>();
        for (String id: inventory.keySet()) {
            if (inventory.get(id) == (Integer)price) {
                list.add(id);
            }
        }
        return list.stream().sorted().collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("P001", 100);
        inventory.put("P002", 50);
        inventory.put("P003", 75);
        inventory.put("P004", 50);
        inventory.put("P005", 75);

        System.out.println(MapInventory.getProductPrice(inventory, "P002")); // Output: 50
        System.out.println(MapInventory.getProductPrice(inventory, "P004")); // Output: 50
        System.out.println(MapInventory.getProductPrice(inventory, "P006")); // Output: -1

        List<String> productsWithPrice50 = MapInventory.getProductIdsByPrice(inventory, 50);
        System.out.println(productsWithPrice50); // Output: [P002, P004]

        List<String> productsWithPrice75 = MapInventory.getProductIdsByPrice(inventory, 75);
        System.out.println(productsWithPrice75); // Output: [P003, P005]

        List<String> productsWithPrice80 = MapInventory.getProductIdsByPrice(inventory, 80);
        System.out.println(productsWithPrice80); // Output: []
    }
}