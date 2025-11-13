public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        if (character != null) {
            int newHealth = character.getCurrentHealth() + healCapacity;
            if (newHealth > character.getMaxHealth()) {
                newHealth = character.getMaxHealth();
            }
            character.setCurrentHealth(newHealth);
        }
    }

    @Override
    public void attack(Character target) {
        this.heal(this); // Heal itself
        if (target != null) {
            target.takeDamage(10);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > 0) {
            setCurrentHealth(Math.max(0, getCurrentHealth() - amount));
        }
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
    }
}
