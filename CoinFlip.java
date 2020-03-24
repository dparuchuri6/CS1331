//I worked on the homework assignment alone, using only course materials.

import java.util.Scanner;
import java.util.Random;

public class CoinFlip {


    public static void main(String[] args) {
        int count = 0;
        int maxFlips = 0;
        int totalFlips = 0;
        int numFlips;
        double average;
        boolean anotherSim = true;

        Scanner myScanner = new Scanner(System.in);
        Random rand = new Random();

        while (anotherSim) {

            System.out.print("Ready to run a coin flip simulation. Enter the number of sequences: ");
            int numSeq = myScanner.nextInt();

            if (numSeq <= 0) {
                continue;
            }

            System.out.print("How many heads should each sequences have? ");
            int numHeads = myScanner.nextInt();

            if (numHeads < 0) {
                continue;
            }

            System.out.print("How many tails should each sequences have? ");
            int numTails = myScanner.nextInt();

            if (numTails < 0) {
                continue;
            }

            System.out.println("Simulating Sequences");

            for (int i = 1; i <= numSeq; i++) {
                numFlips = 0;
                String sequence = "";
                int countHeads = numHeads;
                int countTails = numTails;

                while ((countHeads > 0) || (countTails > 0)) {
                    int randNum = rand.nextInt(2);
                    if ((randNum == 0) && (countHeads > 0)) {
                        sequence += "H";
                        countHeads--;
                        numFlips++;
                    } else if ((randNum == 1) && (countTails > 0)) {
                        sequence += "T";
                        countTails--;
                        numFlips++;
                    } else {
                        numFlips++;
                    }
                }

                if (numFlips > maxFlips) {
                    maxFlips = numFlips;
                }

                totalFlips += numFlips;

                System.out.println(i + " - " + sequence);
            }

            average = ((double) totalFlips) / numSeq;

            System.out.printf("The average number of flips was %-4.2f and maximum was %d\n\n", average, maxFlips);
            count++;

            String response = "";

            while (!((response.equals("y")) || (response.equals("n")))) {
                System.out.print("Would you like to run another simulation? (y/n): ");
                response = myScanner.next();

                if (response.equals("y")) {
                    anotherSim = true;
                    System.out.println();
                }

                if (response.equals("n")) {
                    anotherSim = false;
                    System.out.println();
                }
            }
        }
    }
}
