//I worked on the homework assignment alone,
//using only course materials

public class Board {

    // Place your code here

    private char[][] board = new char[3][3];

    public Board() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public boolean isEmpty(Location location) {
        boolean a = (location.getRow() >= 0) && (location.getRow() < 3);
        boolean b = (location.getColumn() >= 0) && (location.getColumn() < 3);
        return a && b && (board[location.getRow()][location.getColumn()] == ' ');
    }

    public boolean placeLetter(Location location, char ch) {
        if (isEmpty(location)) {
            board[location.getRow()][location.getColumn()] = ch;
            return true;
        } else {
            return false;
        }
    }

    /********************************************************
     *                                                      *
     *      DO NOT MODIFY CODE BELOW THIS BOX               *
     *                                                      *
     ********************************************************/

    /**
     * Returns the current state of the game
     * Either there was a winner, a tie, or it's still ongoing
     * @return current GameState of the board
     */
    public GameState getGameState() {
        GameState current = GameState.ONGOING;
        current = checkHorizontalWin();
        if (current != GameState.ONGOING) {
            return current;
        }
        current = checkVerticalWin();
        if (current != GameState.ONGOING) {
            return current;
        }
        current = checkDiagonalWin();
        if (current != GameState.ONGOING) {
            return current;
        }
        if (checkTie()) {
            return GameState.TIE;
        }
        return GameState.ONGOING;
    }

    private GameState checkHorizontalWin() {
        for (int row = 0; row < 3; row++) {
            char a = board[row][0];
            char b = board[row][1];
            char c = board[row][2];
            if (a == b && b == c) {
                if (a == 'X') {
                    return GameState.PLAYER1_WIN;
                } else if (a == 'O') {
                    return GameState.PLAYER2_WIN;
                }
            }
        }
        return GameState.ONGOING;
    }

    private GameState checkVerticalWin() {
        for (int i = 0; i < 3; i++) {
            char a = board[0][i];
            char b = board[1][i];
            char c = board[2][i];
            if (a == b && b == c) {
                if (a == 'X') {
                    return GameState.PLAYER1_WIN;
                } else if (a == 'O') {
                    return GameState.PLAYER2_WIN;
                }
            }
        }
        return GameState.ONGOING;
    }

    private GameState checkDiagonalWin() {
        char boardMiddle = board[1][1];
        boolean diagnolOne = board[0][0] == boardMiddle && boardMiddle == board[2][2];
        boolean diagnolTwo = board[0][2] == boardMiddle && boardMiddle == board[2][0];
        if (diagnolOne || diagnolTwo) {
            if (boardMiddle == 'X') {
                return GameState.PLAYER1_WIN;
            } else if (boardMiddle == 'O') {
                return GameState.PLAYER2_WIN;
            }
        }
        return GameState.ONGOING;
    }

    private boolean checkTie() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Represents current game board as a String
     * When a Board object is printed, this method will be called
     * @return a String representation of the current game board
     */
    public String toString() {
        String boardString = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j < 2) {
                    boardString += board[i][j] + " | ";
                } else {
                    boardString += board[i][j];
                }
            }
            if (i < 2) {
                boardString += "\n---------\n";
            }
        }
        return boardString + "\n";
    }
}
