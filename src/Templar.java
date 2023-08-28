public class Templar extends Character implements Healer, Tank {
    final private int healCapacity;
    final private int shield;

    Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    public void heal(Character character) {
        character.currentHealth += healCapacity;
        if (character.currentHealth > character.maxHealth) {
            character.currentHealth = character.maxHealth;
        }
    }

    @Override
    public int getShield() {
        return shield;
    }

    public String toString() {
        if (currentHealth > 0) {
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.", name, currentHealth, healCapacity, shield);
        } else {
            return String.format("%s has been beaten. even with its %d. So bad, it could heal %d HP.", name, shield, healCapacity);
        }
    }

    @Override
    public void attack(Character character) {
        heal(this);
        character.takeDamage(6);
    }

    @Override
    public void takeDamage(int damage) {
        damage = damage - shield;
        if (damage > 0) {
            currentHealth -= damage;
        }
    }
}
