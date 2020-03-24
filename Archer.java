//I worked on the homework assignment alone,
//using only course materials

/**
 * Archer class which is subclass
 * of Adventurer class.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-27-02
 */
public class Archer extends Adventurer {
    //Data field for Archer
    private int numArrows;

    /**
     * Constructor with 3 parameters.
     * Defaults number of arrows to 10.
     * Calls superclass constructor.
     * @param name name of Archer
     * @param attack attack power of Archer
     * @param health health of Archer
     */
    public Archer(String name, int attack, int health) {
        super(name, attack, health);
        this.numArrows = 10;
    }

    /**
     * Constructor with one parameter.
     * Constructor chaining to previous constructor.
     * @param name of Archer
     */
    public Archer(String name) {
        this(name, 40, 75);
    }

    /**
     * Getter method for numArrows data field.
     * @return numArrows
     */
    public int getNumArrows() {
        return numArrows;
    }

    @Override
    public void attack(Adventurer a) {
        if ((a != null) && (this.health > 0) && (this.numArrows > 0)) {
            a.health -= this.attack;
            numArrows--;
            if (a.health < 0) {
                a.health = 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        Archer a = (Archer) o;
        if (a instanceof Archer) {
            return super.equals(a);
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
        return super.toString() + ", Arrows: {" + numArrows + "}";
    }
}
