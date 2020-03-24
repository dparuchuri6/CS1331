//I worked on the homework assignment alone,
//using only course materials

import java.util.Scanner;
import java.util.Random;

public class TicTacToe {


    // Place your methods here
    public static void main(String[] args) {

        int numPlayers;

        Scanner input = new Scanner(System.in);
        Board board = new Board();

        numPlayers = getNumberPlayers(input);

        if (numPlayers == 2) {

            while (board.getGameState() == GameState.ONGOING) {

                Location loc1 = getInput("1", input);
                while (!(board.placeLetter(loc1, 'X'))) {
                    loc1 = getInput("1", input);
                }

                System.out.println(board.toString());

                if (board.getGameState() != GameState.ONGOING) {
                    continue;
                }

                Location loc2 = getInput("2", input);
                while (!(board.placeLetter(loc2, 'O'))) {
                    loc2 = getInput("2", input);
                }

                System.out.println(board.toString());

                if (board.getGameState() != GameState.ONGOING) {
                    continue;
                }
            }
        }

        if (numPlayers == 1) {
            while (board.getGameState() == GameState.ONGOING) {

                Location loc1 = getInput("1", input);
                while (!(board.placeLetter(loc1, 'X'))) {
                    loc1 = getInput("1", input);
                }

                System.out.println(board.toString());

                if (board.getGameState() != GameState.ONGOING) {
                    continue;
                }

                System.out.println("The Computer is making a move...");

                Random rand = new Random();
                int row = rand.nextInt(3);
                int col = rand.nextInt(3);
                Location comp = new Location(row, col);

                while (!(board.placeLetter(comp, 'O'))) {
                    row = rand.nextInt(3);
                    col = rand.nextInt(3);
                    comp = new Location(row, col);
                }

                System.out.println(board.toString());

            }
        }

        if (board.getGameState() == GameState.PLAYER1_WIN) {
            System.out.println("Player 1 Wins!");
        } else if ((numPlayers == 1) && (board.getGameState() == GameState.PLAYER2_WIN)) {
            System.out.println("Computer Wins!");
        } else if (board.getGameState() == GameState.PLAYER2_WIN) {
            System.out.println("Player 2 Wins!");
        } else {
            System.out.println("It's a Tie!");
        }
    }

    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

   /**
     * Gets number of players from command line
     * @param sc        for reading from command-line
     * @return number of players (always 1 or 2)
     */
    private static int getNumberPlayers(Scanner sc) {
        boolean repeatPrompt = true;
        int numPlayers = 0;
        while (repeatPrompt) {
            System.out.print("How many players (1 or 2)? ");
            String input = sc.next();
            try {
                numPlayers = Integer.parseInt(input);
                if (numPlayers == 1 || numPlayers == 2) {
                    repeatPrompt = false;
                } else {
                    System.out.println("Enter 1 or 2 players.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please only enter a number.");
            }
        }
        return numPlayers;
    }

   /**
     * Handles scanner calls and user input
     * @param player    whose turn it is
     * @param sc        for reading from command-line
     * @return int[] holding row, column in that order
     */
    private static Location getInput(String player, Scanner sc) {
        boolean repeatPrompt = true;
        int row = -1;
        int col = -1;
        while (repeatPrompt) {
            System.out.print("Enter desired square for " + player + ": ");
            String input = sc.next();
            input = input.trim();
            String[] splitInput = input.split(",");
            try {
                row = Integer.parseInt(splitInput[0]);
                col = Integer.parseInt(splitInput[1]);
                repeatPrompt = false;
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Please follow the format 'row,col'; for ex '1,2'");
            }
        }
        Location loc = new Location(row, col);
        return loc;
    }

}
