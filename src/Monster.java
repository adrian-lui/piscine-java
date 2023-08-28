public class Monster extends Character{
    Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP", name, currentHealth);
        } else {
            return String.format("%s is a monster and is dead", name);
        }
    }
    public static void main(String[] args) {
        Character aragorn = new Character("Aragorn", 20);
        Monster slime = new Monster("Slime", 15);

        System.out.println(Character.printStatus());

        Character winner = Character.fight(aragorn, slime);

        System.out.println(Character.printStatus());
    }
}
