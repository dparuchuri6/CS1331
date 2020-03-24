//I worked on the homework assignment alone, using only course materials.

/**
* Cheese class creates a cheeese object
* with price, type, and numTrades fields and other methods.
*
* @author  Dilip Paruchuri
* @version 1.0
* @since   2020-2-2
*/
public class Cheese {

    private double price;
    private String cheeseType;
    private int numTrades;
    private boolean isSentient;
    private static int totalNumTrades;

   /**
   * Cheese constructor with three paramteters.
   * @param price first parameter of constructor
   * @param cheeseType second parameter of constructor
   * @param numTrades third parameter of constructor
   */
    public Cheese(double price, String cheeseType, int numTrades) {
        this.price = price;
        this.cheeseType = cheeseType;
        this.numTrades = numTrades;
        this.isSentient = false;

        if (!isSentient && numTrades >= 3) {
            isSentient = true;
        }
    }

   /**
   * Cheese constructor with two paramteters.
   * @param price first parameter of constructor
   * @param cheeseType second parameter of constructor
   */
    public Cheese(double price, String cheeseType) {
        this(price, cheeseType, 0);
    }

    /**
    * getPrice() method no parameters.
    * @return price of cheese
    */
    public double getPrice() {
        return price;
    }

    /**
    * getCheeseType() method no parameters.
    * @return type of cheese
    */
    public String getCheeseType() {
        return cheeseType;
    }

    /**
    * getNumTrades() method no parameters.
    * @return number of trades of the cheese
    */
    public int getNumTrades() {
        return numTrades;
    }

    /**
    * getTotalNumTrades() method no parameters.
    * @return total number of trades
    */
    public static int getTotalNumTrades() {
        return totalNumTrades;
    }

    /**
    * isSentient() method no parameters.
    * @return if or not cheese is Sentient
    */
    public boolean isSentient() {
        return isSentient;
    }

    /**
    * setPrice() method no return.
    * @param price new price
    */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
    * setCheeseType() method no return.
    * @param cheeseType new cheese type
    */
    public void setCheeseType(String cheeseType) {
        this.cheeseType = cheeseType;
    }

    /**
    * cheeseTrade() method no param and no return.
    */
    public void cheeseTrade() {
        numTrades++;
        totalNumTrades++;

        if (!isSentient && numTrades >= 3) {
            isSentient = true;
            price *= 2;
            System.out.println("I'm ALIIIIIVE");
        }
    }

    /**
    * equals() method.
    * @param cheese cheese object you are comparing to
    * @return whether or not the two cheese objects are equal
    */
    public boolean equals(Cheese cheese) {
        return (cheeseType.equals(cheese.cheeseType)) && (price == cheese.price) && (isSentient == cheese.isSentient);
    }

    /**
    * toString() method.
    * @return string representation of information
    */
    public String toString() {
        String str = "";
        if (!isSentient) {
            str += "This is a slice of " + this.cheeseType + " cheese that";
            str += " has been traded " + this.numTrades + " times.";
        } else {
            str += "I am a slice of " + this.cheeseType + " cheese that";
            str += " has been traded " + this.numTrades + " times.";
        }

        return str;
    }
}
