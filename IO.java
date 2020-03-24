import java.io.*;
import java.util.Scanner;

public class IO {

    public static void main(String[] args) {

        File file = new File("test.txt");
        File myFile = new File("Dilip.txt");

        // //write name and age to File
        // try {
        //     PrintWriter output = new PrintWriter(file);
        //     output.println("My name is Dilip Paruchuri.");
        //     output.println("I am an engineer at GaTech.");
        //     output.close();
        // } catch (IOException ex) {
        //     System.out.printf("Error: %s\n", ex);
        // }

        try{
            Scanner input = new Scanner(myFile);
            String name  = input.nextLine();
            String career = input.nextLine();
            System.out.println(name + career);
            System.out.println(myFile.getAbsolutePath());

        } catch (IOException ex) {
            System.out.printf("Error: %s\n", ex);
        }
    }
}
