//I worked on the homework assignment alone,
//using only course materials

/**
 * Adventurer class is template from which
 * other heroes are created from.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-27-02
 */
public abstract class Adventurer {

    //Fields that an adventurer contains
    private String name;
    protected  int attack;
    protected int health;

    /**
     * Adventurer constructor with three params.
     * @param name name of Adventurer
     * @param attack attack power of Adventurer
     * @param health health of Adventurer
     */
    public Adventurer(String name, int attack, int health) {
        this.name = name;
        this.attack = attack;
        this.health = health;
    }

    /**
     * Getter method for health data field.
     * @return health of Adventurer
     */
    public int getHealth() {
        return health;
    }

    /**
     * Setter method for health data field.
     * @param health health of Adventurer
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Getter method for attack data field.
     * @return ATTACK
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Abstract method to attack
     * Will be overridden in subclasses.
     * @param a adventurer that will attacked
     */
    public abstract void attack(Adventurer a);

    /**
     * Increases Adventurer's health by 15.
     */
    public void drinkPotion() {
        health += 15;
    }

    @Override
    public boolean equals(Object o) {
        Adventurer a = (Adventurer) o;

        if (a instanceof Adventurer) {
            return (this.name.equals(a.name)) && (this.attack == a.attack) && (this.health == a.health);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.attack;
    }

    @Override
    public String toString() {
        return "Name: {" + name + "}, Health: {" + health + "}, Attack: {" + attack + "}";
    }
}
