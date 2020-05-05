//I worked on the homework assignment alone,
//using only course materials

/**
 * Knight class which is subclass
 * of Adventurer class.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-27-02
 */
public class Knight extends Adventurer {
    //Data field for Knight
    private boolean isSquire;

    /**
     * Constructor with 4 parameters.
     * Invokes super classes constructor.
     * @param name name of Knight
     * @param attack attack power of Knight
     * @param health health of knight
     * @param isSquire whether or not knight has squire
     */
    public Knight(String name, int attack, int health, boolean isSquire) {
        super(name, attack, health);
        this.isSquire = isSquire;
    }

    /**
     * Constructor with 1 parameter.
     * Constructor chaining to previous constructor.
     * @param name name of knight
     */
    public Knight(String name) {
        this(name, 15, 100, true);
    }

    /**
     * Getter method for isSquire data field.
     * @return whether or not Knight has squire
     */
    public boolean isSquire() {
        return isSquire;
    }

    @Override
    public void attack(Adventurer a) {
        if ((this.health > 0) && (a != null)) {
            if (!this.isSquire) {
                a.health -= this.attack;
            } else {
                a.health -= 2 * this.attack;
            }

            if (a.health < 0) {
                a.health = 0;
            }
        }
    }

    /**
     * Knight uses this method to challenge another knight.
     * If kills other knight, steals squire.
     * Otherwise, attacked knight takes revenge shot.
     * @param k knight that will be challenged
     */
    public void challenge(Knight k) {
        if ((k != null) && (this.health > 0) && (!this.isSquire) && (k.isSquire)) {
            this.attack(k);
            if (k.health == 0) {
                k.isSquire = false;
                this.isSquire = true;
            } else {
                k.attack(this);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        Knight k = (Knight) o;
        if (k instanceof Knight) {
            return (super.equals(k)) && (this.isSquire == k.isSquire);
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
        return super.toString() + ", Squire: {" + isSquire + "}";
    }

}
