//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;

public class TipCalculator {

  public static void main(String[] args) {

      int count = 1;
      double subtotal = 0;
      double tip = 0;
      double cost = 0;

      Scanner myScanner = new Scanner(System.in);

      System.out.println("Welcome to Tip Calculator!\n");
      System.out.print("Enter the prices of your items. ");
      System.out.print("Enter -1 to enter tip percentage.\n");

      System.out.print("Item " + count + ": $");
      cost = myScanner.nextDouble();

      while(cost != -1) {
        subtotal += cost;
        count++;
        System.out.print("Item " + count + ": $");
        cost = myScanner.nextDouble();
      }

      if (cost == -1) {
        System.out.print("\nEnter the tip percentage: ");
        tip = myScanner.nextDouble();
      }

      System.out.printf("\nSubtotal: $%-5.2f", subtotal);
      System.out.printf("\nTip:\t  $%-4.2f", subtotal*tip);
      System.out.printf("\nTotlal:\t  $%-5.2f", subtotal + subtotal*tip);
  }
}
