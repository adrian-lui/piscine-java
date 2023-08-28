import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Character {

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

    public abstract void takeDamage(int damage);

    public abstract void attack(Character character);

    public static void main(String[] args) {
        Templar alistair = new Templar("Alistair", 18, 2, 4);
        Sorcerer morrigan = new Sorcerer("Morrigan", 21, 5);
        Monster dragon = new Monster("Dragon", 12);

        dragon.attack(alistair);
        dragon.attack(morrigan);

        alistair.attack(dragon);
        morrigan.attack(dragon);

        System.out.println(Character.printStatus());
    }
}
