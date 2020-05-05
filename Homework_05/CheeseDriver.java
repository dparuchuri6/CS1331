//I worked on the homework assignment alone, using only course materials.

/**
* CheeseDriver class tests Cheese and Cheese connoisseur classes.
*
* @author  Dilip Paruchuri
* @version 1.0
* @since   2020-2-2
*/
public class CheeseDriver {

    /**
     * This is the main method.
     * @param args Unused.
     */
    public static void main(String[] args) {

        Cheese c1 = new Cheese(5, "Pepperjack", 0);
        Cheese c2 = new Cheese(5, "Pepperjack");
        Cheese c3 = new Cheese(3, "Swiss", 2);
        Cheese c4 = new Cheese(2, "Provolone", 5);
        Cheese c5 = new Cheese(15, "Cheddar", 15);

        CheeseConnoisseur cc1 = new CheeseConnoisseur("Dilip", 30, c1);
        CheeseConnoisseur cc2 = new CheeseConnoisseur();

        cc2.trade(c3);
        cc1.trade(cc2);
        cc1.trade(c4);
        cc1.trade(cc2);
        cc1.trade(c5);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
    }
}
