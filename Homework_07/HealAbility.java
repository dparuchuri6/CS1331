//I worked on the homework assignment alone, using only course materials.

/**
 * Represents an interface called HealAbility with
 * methods to heal patient and sort.
 * @author Dilip Paruchuri
 * @version 1.0
 */

public interface HealAbility {

   /**
   * Heals all patients in the array.
   * @param p imput of a patient
   */
    void performHeal(Patient[] p);

   /**
   * Method indicates how much patient is healed.
   * @return integer number of healed health
   */
    int getHealAmount();

     /**
     * PROVIDED METHOD, DO NOT CHANGE
     * Sorts a list of Patients based on their compareTo method.
     * Note: this will not work until you implement compareTo in
     * Patient correctly!
     * @param patientlist a list of Patient objects to sort based on their
     *                    compareTo method
     */
    static void sortPatients(Patient[] patientlist) {
        for (int i = 1; i < patientlist.length; i++) {
            int j = i;
            while (j > 0 && patientlist[j - 1].compareTo(patientlist[j]) > 0) {
                Patient temp = patientlist[j];
                patientlist[j] = patientlist[j - 1];
                patientlist[j - 1] = temp;
                j--;
            }
        }
    }
}
