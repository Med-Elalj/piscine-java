public class Monster extends Character {

    private Weapon weapon;

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        String weaponInfo = (weapon != null) ? " He has the weapon " + weapon.toString() : "";
        if (this.isAlive()) {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP." + weaponInfo;
        } else {
            return this.getName() + " is a monster and is dead." + weaponInfo;
        }
    }

    public boolean isAlive() {
        return this.getCurrentHealth() > 0;
    }

    @Override
    public void attack(Character target) throws DeadCharacterException {
        if (!this.isAlive()) {
            throw new DeadCharacterException(this);
        }
        if (target != null) {
            int damage = (weapon != null) ? weapon.getDamage() : 7;
            target.takeDamage(damage);
        }
    }

    @Override
    public void takeDamage(int amount) throws DeadCharacterException {
        if (!this.isAlive()) {
            throw new DeadCharacterException(this);
        }
        if (amount > 0) {
            int reducedDamage = (int) Math.floor(amount * 0.8);
            setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
        }
    }
}