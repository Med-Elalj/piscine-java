public class Sorcerer extends Character implements Healer {
    private final int healCapacity;
    private Weapon weapon;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.weapon = weapon;
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
    public void attack(Character target) throws DeadCharacterException {
        if (!this.isAlive()) {
            throw new DeadCharacterException(this);
        }
        this.heal(this); // Heal itself
        if (target != null) {
            try {
                int damage = (weapon != null) ? weapon.getDamage() : 10;
                target.takeDamage(damage);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void takeDamage(int amount) throws DeadCharacterException {
        if (!this.isAlive()) {
            throw new DeadCharacterException(this);
        }
        if (amount > 0) {
            setCurrentHealth(Math.max(0, getCurrentHealth() - amount));
        }
    }

    @Override
    public String toString() {
        String weaponInfo = (weapon != null) ? " He has the weapon " + weapon.toString() : "";
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP." + weaponInfo;
        }
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP." + weaponInfo;
    }
}
