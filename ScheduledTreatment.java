/**
 * Represents a Scheduled Treatment object with a healt amount, patientID to heal
 * and methods that act on those Treatment objects.
 * @author Dilip Paruchuri
 * @version 1.0
 */
public class ScheduledTreatment extends Treatment {

    private int treatPatientID;

    /**
    * Initializes EmergencyTreatment from Treatment construtor.
    * @param heal	amount the EmergencyTreatment heals
		* @param treatPatientID id of patient to be treated
    */
    public ScheduledTreatment(int heal, int treatPatientID) {
        super(heal);
        this.treatPatientID = treatPatientID;
    }

    @Override
    public void performHeal(Patient[] p) {
        int m = 0;
        int n = p.length;
        int avg;
        int pos = -1;

        if (n == 0) {
            System.out.println("Patient does not exist");
            return;
        }

        HealAbility.sortPatients(p);

        while (m < n) {
            avg = (m + n) / 2;
            if (p[avg].getPatientID() < treatPatientID) {
                m = avg + 1;
            } else if (p[avg].getPatientID() > treatPatientID) {
                n = avg - 1;
            } else {
                pos = avg;
                break;
            }
        }

        if (pos != -1) {
            HealAbility h = (HealAbility) this;
            p[pos].increaseHealth(h);
        } else {
            System.out.println("Patient does not exist");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
