public class Templar extends Character implements Healer, Tank {

    private final int healCapacity;
    private final int shield;
    private Weapon weapon;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
        this.weapon = weapon;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character character) {
        int newHealth = character.getCurrentHealth() + healCapacity;
        if (newHealth > character.getMaxHealth()) {
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(newHealth);
        }
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        String weaponInfo = (weapon != null) ? " He has the weapon " + weapon.toString() : "";
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP." + weaponInfo;
        } else {
            return getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + "." + weaponInfo;
        }
    }

    @Override
    public void attack(Character target) {
        this.heal(this); // Heal itself
        if (target != null) {
            int damage = (weapon != null) ? weapon.getDamage() : 6;
            target.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > 0) {
            int reducedDamage = Math.max(0, amount - shield);
            setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
        }
    }
}