public class Weapon {
    private String name;
    public String getName() {
        return name;
    }

    private int damage;
    public int getDamage() {
        return damage;
    }

    Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String toString() {
        return String.format("%s deals %d damages", name, damage);
    }
}
