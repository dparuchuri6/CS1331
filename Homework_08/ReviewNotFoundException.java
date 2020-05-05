//I worked on the homework assignment alone,
//using only course materials

/**
 * ReviewNotFoundException class which
 * extends from the Exception class.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-23-03
 */
public class ReviewNotFoundException extends Exception {
    /**
    * Class constructor.
    * @param message message that is displayed when exception occurs
    */
    public ReviewNotFoundException(String message) {
        super(message);
    }
}
