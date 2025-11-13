import java.util.ArrayList;
import java.util.List;

public abstract class Character {

    private final int maxHealth;
    private int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();
    private Weapon weapon;

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getName() {
        return name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract void takeDamage(int amount) throws DeadCharacterException;

    public abstract void attack(Character target) throws DeadCharacterException;

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\n" +
                   "Nobody's fighting right now !\n" +
                   "------------------------------------------\n";
        }

        StringBuilder status = new StringBuilder("------------------------------------------\n");
        status.append("Characters currently fighting :\n");
        for (Character character : allCharacters) {
            status.append(" - ").append(character.toString()).append("\n");
        }
        status.append("------------------------------------------\n");
        return status.toString();
    }

    public static Character fight(Character c1, Character c2) {
        if (c1 == null || c2 == null) return null;

        while (c1.getCurrentHealth() > 0 && c2.getCurrentHealth() > 0) {
            try {
                c1.attack(c2);
                if (c2.getCurrentHealth() == 0) {
                    return c1;
                }
                c2.attack(c1);
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
            }
        }

        return c2.getCurrentHealth() > 0 ? c2 : c1;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public boolean isAlive() {
        return this.getCurrentHealth() > 0;
    }
}
