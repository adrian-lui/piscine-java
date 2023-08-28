import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Character {

    private static List<Character> allCharacters = new ArrayList<>();
    final protected int maxHealth;

    public int getMaxHealth() {
        return maxHealth;
    }
    final protected String name;

    public String getName() {
        return name;
    }

    protected int currentHealth;
    public int getCurrentHealth() {
        return currentHealth;
    }


    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        Character.allCharacters.add(this);
    }

    public static String printStatus() {
        if (Character.allCharacters.size() == 0) {
            return "------------------------------------------\n" +
                    "Nobody's fighting right now !\n" +
                    "------------------------------------------";
        } else {
            return String.format("------------------------------------------\n" +
                "Characters currently fighting : \n" +
                "%s" +
                "------------------------------------------", Character.allCharacters.stream().map(character -> String.format(" - %s\n", character.toString())).collect(Collectors.joining()));
        }
    }

    public static Character fight(Character character1, Character character2) {
        while (true) {
            character1.attack(character2);
            if (character2.getCurrentHealth() == 0) {
                return character1;
            }
            character2.attack(character1);
            if (character1.getCurrentHealth() == 0) {
                return character2;
            }
        }
    }

    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s: KO", name);
        } else {
            return String.format("%s: %d/%d", name, currentHealth, maxHealth);
        }
    }

    public void takeDamage(int damage) {
        if (damage > currentHealth) {
            currentHealth = 0;
        } else {
            currentHealth -= damage;
        }
    }

    public void attack(Character character) {
        character.takeDamage(9);
    }

    public static void main(String[] args) {
        System.out.println(Character.printStatus());

        Character aragorn = new Character("Aragorn", 20);
        Character uruk = new Character("Uruk", 15);

        System.out.println(Character.printStatus());

        Character winner = Character.fight(aragorn, uruk);

        System.out.println(winner.toString());
        System.out.println(Character.printStatus());
    }
}
