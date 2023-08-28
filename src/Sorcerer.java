public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        character.currentHealth += healCapacity;
        if (character.currentHealth > character.maxHealth) {
            character.currentHealth = character.maxHealth;
        }
    }

    public String toString() {
        if (currentHealth > 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP", name, currentHealth, healCapacity);
        } else {
            return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", name, healCapacity);
        }
    }
}
