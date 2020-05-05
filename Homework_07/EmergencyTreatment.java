/**
 * Represents an Emergency Treatment object with a heal amount
 * and methods that act on those Treatment objects.
 * @author Dilip Paruchuri
 * @version 1.0
 */

public class EmergencyTreatment extends Treatment {

    /**
    * Initializes EmergencyTreatment from Treatment construtor.
    * @param heal	amount the EmergencyTreatment heals
    */
    public EmergencyTreatment(int heal) {
        super(heal);
    }

    /**
    * Linear search through array of patients
    * and find patient with least health and health
		* that one patient.
    */
    @Override
    public void performHeal(Patient[] p) {

        if (p.length == 0) {
            System.out.println("No patients to heal.");
            return;
        }

        int minPosition = 0;
        int minHealth = p[0].getHealth();
        for (int i = 1; i < p.length; i++) {
            if (p[i].getHealth() < minHealth) {
                minHealth = p[i].getHealth();
                minPosition = i;
            } else {
                continue;
            }
        }
        HealAbility h = (HealAbility) this;
        p[minPosition].increaseHealth(h);
    }
}
