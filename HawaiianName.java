import java.util.Scanner;

public class HawaiianName {

  public static void main(String[] args) {
      String tryAgain;

      System.out.println("Welcome to Hawaii! Let's check if your name is Hawaiin enough.");
      Scanner myScanner = new Scanner(System.in);

      do {
        int count = 0;
        String name;
        String lowerCaseName;
        String newName = "";

        System.out.print("\nEnter your name: ");
        name = myScanner.nextLine();
        lowerCaseName = name.toLowerCase();

        for (int i = 0; i < lowerCaseName.length(); i++) {
           switch(lowerCaseName.charAt(i)) {
             case 'a':
             case 'e':
             case 'i':
             case 'o':
             case 'u':
             case 'k':
             case 'l':
             case 'h':
             case 'm':
             case 'n': newName += Character.toString(name.charAt(i));
                       break;
             default: count++;
           }
         }

         if (count == 0) {
           System.out.println("Aloha, " + name);
         } else {
           System.out.println("Sorry " + name + ", you aren't Hawaiin enough to come!");
           System.out.println("Let's make your name... " + newName + "!");
           System.out.println("Aloha, " + newName);
         }

         System.out.print("Would you like to try again? (y/n) ");
         tryAgain = myScanner.nextLine();

       } while (tryAgain.equals("y"));
     }
}
