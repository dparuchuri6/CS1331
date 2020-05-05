//I worked on the homework assignment alone,
//using only course materials

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * YelpDB class with help methods
 * and main method to test methods.
 * @author Dilip Paruchuri
 * @version 1.0
 * @since 2020-23-03
 */
public class YelpDB {

    /**
    * Main method used to test helped methods.
    * @param args String array input values from cmd line
    * @throws NotARestaurantException when wrong restaurant entered
    */
    public static void main(String[] args) throws NotARestaurantException {
        //Entire Directory
        File restDir = new File("database_restaurants");
        //Partial directories for testing
        File[] typeFood = restDir.listFiles();
        //ArrayList with all restaurant names
        ArrayList<Restaurant> a = load(restDir);

        /*Print array for testing visualization
        printArrayList(a);
        */

        //Testing countNumReviews() method
        System.out.println("Total Reviews of " + restDir.getName() + ": " + countNumReviews(a));

        //Testing readReview() method
        try {
            System.out.println(args[1] + "\'s review of " + args[0] + ": " + readReview(restDir, a, args[0], args[1]));
        } catch (NotARestaurantException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (ReviewNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
    * Method that creates list of restaurant objects.
    * @param file file that restaurants will be copied from
    * @return Restaurant ArrayList of all restaurants in the file
    */
    public static ArrayList<Restaurant> load(File file) {
        ArrayList<Restaurant> a = new ArrayList<Restaurant>();
        ArrayList<Restaurant> list = loadHelper(file, a);
        return list;
    }

    /**
    * Method that recursively creates a list of restaurants.
    * @param file file from which restaurants are selected
    * @param a ArrayList of restaurants to which restaurants are added
    * @return Restaurant ArrayList of all restaurants in the file
    */
    public static ArrayList<Restaurant> loadHelper(File file, ArrayList<Restaurant> a) {
        if ((file.getName().length() > 9) && (file.getName().substring(0, 10).equals("restaurant"))) {
            Restaurant restaurant = new Restaurant(file.getName().substring(10), file.listFiles().length);
            a.add(restaurant);
        } else if ((file.getName().length() > 6) && (file.getName().substring(0, 6).equals("review"))) {
            return a;
        } else {
            File[] f = file.listFiles();
            for (int i = 0; i < f.length; i++) {
                a = loadHelper(f[i], a);
            }
        }
        return a;
    }

    /**
    * Method that counts the total number of reviews.
    * @param a ArrayList of restaurants to which restaurants are added
    * @return total number of reviews
    */
    public static int countNumReviews(ArrayList<Restaurant> a) {
        int total = 0;
        for (int i = 0; i < a.size(); i++) {
            total += a.get(i).getNumReviews();
        }
        return total;
    }

    /**
    * Method that prints ArrayList Restaurant info.
    * @param a ArrayList to print out
    */
    public static void printArrayList(ArrayList<Restaurant> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%-10s" + a.get(i).getNumReviews() + "\n", a.get(i).getName());
        }
    }

    /**
    * Method that reads a reviews and returns the rating.
    * @param file file to find review from
    * @param a ArrayList of restaurant objects
    * @param restaurantName name of restaurant that review belongs to
    * @param reviewName name of the person who wrote review
    * @return rating that the person gave the specific restaurant
    * @throws NotARestaurantException when invalid restaurant is an input
    * @throws FileNotFoundException when file is not found in directory
    * @throws ReviewNotFoundException when review file is not found in the input directory
    */
    public static double readReview(File file, ArrayList<Restaurant> a, String restaurantName, String reviewName)
        throws NotARestaurantException, FileNotFoundException, ReviewNotFoundException {
        int count = 0;
        boolean reviewFound = false;
        double rating = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getName().equals(restaurantName)) {
                count++;
            }
        }

        if (count == 0) {
            throw new NotARestaurantException();
        }

        File myFile = locate(file, restaurantName);

        if (myFile == null) {
            throw new FileNotFoundException("File Not Found!");
        }

        for (int i = 0; i < myFile.listFiles().length; i++) {
            if (myFile.listFiles()[i].getName().equals("review" + reviewName + ".txt")) {
                Scanner input = new Scanner(myFile.listFiles()[i]);
                while (input.hasNext()) {
                    if (input.next().equals("Rating:")) {
                        rating = input.nextDouble();
                    }
                }
                input.close();
                reviewFound = true;
                break;
            }
        }

        if (reviewFound) {
            return rating;
        } else {
            throw new ReviewNotFoundException("Review not found!");
        }
    }

    /**
    * Method that recursively locates a file with a directory
    * @param file file/directory that is being searched
    * @param restaurantName name of file that is being searched for
    * @return file with the restuarant name or null
    */
    private static File locate(File file, String restaurantName) {
        File result = null;
        if (file.getName().equals("restaurant" + restaurantName)) {
            return file;
        } else {
            if (file.isDirectory()) {
                for (int i = 0; i < file.listFiles().length; i++) {
                    result = locate(file.listFiles()[i], restaurantName);
                    if (result != null) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
