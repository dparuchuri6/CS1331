/**
 * Represents a Patient object with a particular name,
 * health attribute that will be always greater or equal to 0
 * but should never exceed maxHealth. (assume that whoever makes an instance of this
 * object does it in the correct way; you do not need to change the constructor.)
 * There are a few methods in here for you to implement, in addition to changing
 * the class header such that Patient properly implements the Comparable interface
 * @author Dilip Paruchuri
 * @version 1.0
 */

public class Patient implements Comparable<Patient> {

    //instance data for Patient
    private String name;
    private int health;
    private int patientID;

    /**
    * Initializes a Patient object with following data.
    * @param name 			name of patient
    * @param patientID		id of patient
    * @param health		health of patient
    */
    public Patient(String name, int health, int patientID) {
        this.name = name;
        this.health = health;
        this.patientID = patientID;
    }

    /**
    * Getter method for health variable.
    * @return health of patient
    */
    public int getHealth() {
        return health;
    }

    /**
    * Getter method for patientID variable.
		* @return patient ID number
    */
    public int getPatientID() {
        return patientID;
    }

    /**
    * Increase patient health by amount of Treatment's heal.
    * @param h		any object that implements HealAbility
		*/
    public void increaseHealth(HealAbility h) {
        int numHeal = ((Treatment) h).getHealAmount();
        this.health += numHeal;
        System.out.println("Patient " + name + " has been healed by " + numHeal + " health points!");
    }

    @Override
		public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof Patient)  {
            Patient p = (Patient) o;
            return (name.contentEquals(p.name)) && (health == p.health) && (patientID == p.patientID);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.patientID;
    }

    @Override
		public int compareTo(Patient p) {
        if (this.patientID < p.patientID) {
            return -1;
        } else if (this.patientID > p.patientID) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("Patient '%s' with %d health and ID %d", name, health, patientID);
    }
}
