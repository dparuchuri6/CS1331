//I worked on the homework assignment alone,
//using only course materials

//import Scanner Class
import java.util.Scanner;

public class LeetTranslator {

  public static void main(String[] args) {
      //create Scanner object
      Scanner input = new Scanner(System.in);
      //prompt user for string
      System.out.print("Enter string to translate: ");
      String sentence = input.nextLine();
      //Converting sentence into Leetspeak
      String lowerCaseString = sentence.toLowerCase();
      String replaceOne = lowerCaseString.replace("a","@");
      String replaceTwo = replaceOne.replace("e","3");
      String replaceThree = replaceTwo.replace("i","1");
      String replaceFour = replaceThree.replace("s","$");
      String finalReplace = replaceFour.replace("o","0");
      //Print Translation
      System.out.println(finalReplace);
  }
}
