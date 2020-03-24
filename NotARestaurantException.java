//I worked on the homework assignment alone,
//using only course materials

/**
 * NotARestaurantException class which
 * extends from the Exception class.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-23-03
 */

public class NotARestaurantException extends Exception {

    /**
    * No arg contructor for class.
    */
    public NotARestaurantException() {
        super("That is not a restaurant we know!");
    }
}
