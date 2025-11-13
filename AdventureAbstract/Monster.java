public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (this.isAlive()) {
            return this.getName() + " is a monster with " + this.getCurrentHealth() + " HP";
        } else {
            return this.getName() + " is a monster and is dead";
        }
    }

    public boolean isAlive() {
        return this.getCurrentHealth() > 0;
    }

    @Override
    public void attack(Character target) {
        if (target != null) {
            target.takeDamage(7);
        }
    }

    @Override
    public void takeDamage(int amount) {
        if (amount > 0) {
            int reducedDamage = (int) Math.floor(amount * 0.8);
            setCurrentHealth(Math.max(0, getCurrentHealth() - reducedDamage));
        }
    }
}