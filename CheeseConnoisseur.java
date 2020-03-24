//I worked on the homework assignment alone, using only course materials.

/**
* Cheese class creates a cheeese object
* with price, type, and numTrades fields and other methods.
*
* @author  Dilip Paruchuri
* @version 1.0
* @since   2020-2-2
*/
public class CheeseConnoisseur {

    private String name;
    private Cheese cheese;
    private double totalMoney;

    /**
    * CheeseConnoisseur constructor with three paramteters.
    * @param name name of person
    * @param totalMoney total money of connoisseur
    * @param cheese cheese object connoisseur has
    */
    public CheeseConnoisseur(String name, double totalMoney, Cheese cheese) {
        this.name = name;
        this.totalMoney = totalMoney;
        this.cheese = cheese;
    }

    /**
    * CheeseConnoisseur constructor with 1 paramteters.
    * @param name name of person
    */
    public CheeseConnoisseur(String name) {
        this(name, 0, null);
    }

    /**
    * CheeseConnoisseur constructor with 0 paramteters.
    */
    public CheeseConnoisseur() {
        this("Louis Pasteur", 20.00, null);
    }

    /**
    * getName() with no paramteters.
    * @return name of connoisseur
    */
    public String getName() {
        return this.name;
    }

    /**
    * getCheese() with no paramteters.
    * @return cheese of connoisseur
    */
    public Cheese getCheese() {
        return this.cheese;
    }

    /**
    * getTotalMoney() with no paramteters.
    * @return total money of connoisseur
    */
    public double getTotalMoney() {
        return this.totalMoney;
    }

    /**
    * setCheese() with no return.
    * @param cheese setting new cheese
    */
    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    /**
    * setTotalMoney() with no return.
    * @param totalMoney setting new money
    */
    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
    * trade() with no return.
    * @param cheese cheese that is being traded.
    */
    public void trade(Cheese cheese) {
        if (this.cheese == null) {
            cheese.cheeseTrade();
            this.cheese = cheese;
        } else {
            this.cheese.cheeseTrade();
            cheese.cheeseTrade();
            this.cheese = cheese;
        }
    }

    /**
    * trade() with no return.
    * @param cheeseConnoisseur cheese connoisseur that this is trading with.
    */
    public void trade(CheeseConnoisseur cheeseConnoisseur) {
        if ((this.cheese != null) && (cheeseConnoisseur.cheese != null)) {
            if (!this.cheese.equals(cheeseConnoisseur.cheese)) {
                double diff = Math.abs(this.cheese.getPrice() - cheeseConnoisseur.cheese.getPrice());
                if (this.cheese.getPrice() < cheeseConnoisseur.cheese.getPrice()) {
                    if (this.totalMoney >= diff) {
                        this.cheese.cheeseTrade();
                        cheeseConnoisseur.cheese.cheeseTrade();
                        Cheese c = this.cheese;
                        this.cheese = cheeseConnoisseur.cheese;
                        cheeseConnoisseur.cheese = c;
                        this.totalMoney = this.totalMoney - diff;
                        cheeseConnoisseur.totalMoney = cheeseConnoisseur.totalMoney + diff;
                    }
                } else if (this.cheese.getPrice() > cheeseConnoisseur.cheese.getPrice()) {
                    if (cheeseConnoisseur.cheese.getPrice() >= diff) {
                        this.cheese.cheeseTrade();
                        cheeseConnoisseur.cheese.cheeseTrade();
                        Cheese c = this.cheese;
                        this.cheese = cheeseConnoisseur.cheese;
                        cheeseConnoisseur.cheese = c;
                        cheeseConnoisseur.totalMoney = cheeseConnoisseur.totalMoney - diff;
                        this.totalMoney = this.totalMoney + diff;
                    }
                }
            }
        }
    }
}
