//I worked on the homework assignment alone,
//using only course materials

//import Scanner Class
import java.util.Scanner;

public class CoinChanger {

  public static void main(String[] args) {

      ///create Scanner object
      Scanner input = new Scanner(System.in);
      //Prompt number of pennies
      System.out.print("Pennies: ");
      int pennies = input.nextInt();
      //Prompt number of nickles
      System.out.print("Nickels: ");
      int nickels = input.nextInt();
      //Prompt number of dimes
      System.out.print("Dimes: ");
      int dimes = input.nextInt();
      //Prompt number of quarters
      System.out.print("Quarters: ");
      int quarters = input.nextInt();
      //total amount in pennies
      int total = 1*pennies + 5*nickels + 10*dimes + 25*quarters;
      //quotient results in dollars
      int dollars = total / 100;
      //remainder results in cents
      int cents = total % 100;

      System.out.print("Total is " + dollars + " dollars ");
      System.out.println("and " + cents + " cents.");

  }
}
