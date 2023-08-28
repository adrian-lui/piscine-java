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

    @Override
    public void attack(Character character) {
        character.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        {
            if (damage > currentHealth) {
                currentHealth = 0;
            } else {
                currentHealth = currentHealth - (int)(Math.ceil((float)damage * 0.8));
            }
        }
    }
}
