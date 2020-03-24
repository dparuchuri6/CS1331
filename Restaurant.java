//I worked on the homework assignment alone,
//using only course materials

/**
 * Restaurant class from which
 * other restaurants are created from.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-23-03
 */
public class Restaurant {
    //Fields Restaurant contains
    private String name;
    private int numReviews;

    /**
     * Constructor for restaurant class.
     * @param name name of restaurant
     * @param numReviews number of reviews
    */
    public Restaurant(String name, int numReviews) {
        this.name = name;
        this.numReviews = numReviews;
    }

    /**
    * Getter method to access restaurant name.
    * @return name of the restaurant
    */
    public String getName() {
        return this.name;
    }

    /**
    * Getter method to access number of reviews.
    * @return number of restaurant reviews
    */
    public int getNumReviews() {
        return this.numReviews;
    }
}
