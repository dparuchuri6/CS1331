/**
 * Represents an abstract Treatment object with a heal amount
 * and methods that act on those Treatment objects.
 * @author Dilip Paruchuri
 * @version 1.0
 */

public abstract class Treatment implements HealAbility {

    //how much healing treatment gives
    private int heal;

    /**
    * Constructor with designated heal amount.
    * @param heal heal amount
    */
    public Treatment(int heal) {
        this.heal = heal;
    }

    /**
    * Default constructor with heal 5.
    */
    public Treatment() {
        this(5);
    }

    /**
    * Heals all patients in the array.
    * @param p patient input
    */
    public abstract void performHeal(Patient[] p);

    /**
		* Method indicates how much patient is healed.
    * @return integer number of healed health
		*/
    public int getHealAmount() {
        return heal;
    }

    @Override
    public String toString() {
        return "Treatment with " + heal + " heal";
    }
}
