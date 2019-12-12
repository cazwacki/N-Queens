/**
 * SeriesAlg is a container class for the methods related to the series-based
 * algorithm developed by Vishal Kesri and Manoj Kumar Mishra adapted for Java.
 * The algorithm uses a 2D array to execute elements of the algorithm. -1
 * repesents a position with a queen in it.
 * 
 * @author Charles Zawacki
 * @version 12/7/2019
 *
 */
public class SeriesAlg {

    private static int[][] board;
    private static int boardSize;


    /**
     * Provides the solution to a board of size n x n upon which n queens must
     * be placed.
     * 
     * @param n
     *            the dimensions of the chessboard and the number of queens to
     *            place on the board.
     */
    public static int[][] solve(int n) {
        boardSize = n;
        board = new int[n][n];
        System.out.println("Series is " + getSeries(n));
        switch (getSeries(n)) {
            case 1:
                // completed
                move1(0, (n / 3) - 1);
                move1(1, (n / 3 * 2) - 1);
                move1(2, n - 1);
                break;
            case 2:
                // completed
                // get the solution of the n-1 chessboard
                board = new int[n - 1][n - 1];
                move1(0, ((n - 1) / 3) - 1);
                move1(1, ((n - 1) / 3 * 2) - 1);
                move1(2, (n - 1) - 1);
                board = sizeBoardUp();
                // apply rule 1
                rule1();
                break;
            case 3:
                // completed
                move1(1, (n - 1) / 3 - 1);
                move1(0, ((n - 1) / 3) * 2);
                move1(2, n - 1);
                break;
            case 4:
                // completed
                // get the solution of the n-1 chessboard
                board = new int[n - 1][n - 1];
                move1(1, ((n - 1) - 1) / 3 - 1);
                move1(0, (((n - 1) - 1) / 3) * 2);
                move1(2, (n - 1) - 1);
                board = sizeBoardUp();
                // apply rule 1
                rule1();
                break;
            case 5:
                // completed
                move2(0, n / 2 - 1);
                move3(n - 1, n / 2 + 1);
                break;
            case 6:
                // completed
                move2(1, (n - 1) / 2 - 1);
                move3(n - 1, (n - 1) / 2 + 1);
                rule2();
                break;
            case 7:
                // completed
                move2(0, n / 2);
                move3(n - 1, n / 2 + 2);
                board[1][0] = -1;
                break;
            case 8:
                // completed
                move2(1, (n - 1) / 2 + 1);
                move3(n - 1, (n - 1) / 2 + 3);
                board[0][0] = -1;
                board[2][1] = -1;
                break;
        }
        analyze();
        printBoard();
        return board;
    }


    private static int[][] sizeBoardUp() {
        int[][] newBoard = new int[board.length + 1][board.length + 1];
        for (int i = 0; i < boardSize - 1; i++) {
            for (int j = 0; j < boardSize - 1; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        return newBoard;
    }


    private static void analyze() {
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
                if (board[a][b] != -1) {
                    board[a][b] = 0;
                }
            }
        }
        // mark paths where queens could potentially attack ,
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
                if (board[a][b] == -1) {
                    markAttackPaths(a, b);
                }
            }
        }
    }


    /**
     * Marks positions that are ineligible for another queen to be placed. For
     * example:
     * 0 0 Q 0 0 | By incrementing the paths the queen can take by 1, we have
     * 0 1 1 1 0 | marked all positions in which another queen cannot be
     * 1 0 1 0 1 | placed. By doing this with multiple queens, we can isolate
     * 0 0 1 0 0 | potential positions for future queens. The eligible positions
     * 0 0 1 0 0 | will be designated with a value of 0 (as they have not been
     * incremented.
     * 
     * @param a
     *            the row where the queen is located.
     * @param b
     *            the column where the queen is located.
     */
    private static void markAttackPaths(int a, int b) {
        // increment row and column (done in that order)
        for (int i = 0; i < board.length; i++) {
            if (board[a][i] != -1) {
                board[a][i]++;
            }
            if (board[i][b] != -1) {
                board[i][b]++;
            }
        }
        // handle diagonals
        for (int c = 0; c < board.length; c++) {
            for (int d = 0; d < board[c].length; d++) {
                if (Math.abs((c - a) * 1.0 / (d - b)) == 1) {
                    if (board[c][d] != -1) {
                        board[c][d]++;
                    }
                }
            }
        }
    }


    /**
     * Rule 1 is executed when the size of the board falls under one of the
     * following series: {S2, S4}
     */
    private static void rule1() {
        // call analyzer function with the updated dimensions
        analyze();
        // place a queen where position(x, y) = 0
        for (int a = 0; a < board.length; a++) {
            for (int b = 0; b < board[a].length; b++) {
                if (board[a][b] == 0) {
                    board[a][b] = -1;
                    return;
                }
            }
        }
    }


    private static void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    System.out.print("Q ");
                }
                else {
                    // System.out.print("- ");
                    if (board[i][j] != 0) {
                        System.out.print(board[i][j] + " ");
                    }
                    else {
                        System.out.print("- ");
                    }
                }
            }
            System.out.println();
        }
    }


    /**
     * Rule 2 is executed when the board falls within series S6.
     */
    private static void rule2() {
        analyze();
        int x = 0;
        int y = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][board.length - 1] == board[0][j]
                    && board[0][j] == 1) {
                    if (i - 1 != board.length - 1 - j) {
                        if (board[i][j] == -1) {
                            x = i;
                            y = j;
                            board[i][j] = 0;
                        }
                    }
                }
            }
        }
        analyze();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 && (x != i || y != j)) {
                    board[i][j] = -1;
                }
            }
        }
    }


    /**
     * move1 increases the row value of the board by 3 and reduces the column
     * value by 1. The first queen's placement is dependent on the series under
     * which the board size falls.
     */
    private static void move1(int i, int j) {
        board[i][j] = -1;
        for (int a = 0; (a + 3) < board.length;) {
            i = i + 3;
            j = j - 1;
            if (j > -1) {
                board[i][j] = -1;
            }
            a = i;
        }
    }


    /**
     * move2 increases the row value of the chess board by 2 and reduces the
     * column value by 1. The placement of the first queen is dependent on the
     * series under which the size of the chessboard falls.
     */
    private static void move2(int i, int j) {
        board[i][j] = -1;
        for (int a = 0; (a + 2) < board.length;) {
            i = i + 2;
            j = j - 1;
            board[i][j] = -1;
            a = i;
        }
    }


    /**
     * move3 decreases the row value of the chess board by 2 and increases the
     * column value by 3 or 1 based on the given count. The placement of the
     * first queen is dependent on the series under which the size of the
     * chessboard falls.
     */
    private static void move3(int i, int j) {
        int count = 1;
        board[i][j] = -1;
        for (int a = boardSize - 1; (a - 2) >= 0;) {
            i = i - 2;
            if (count % 2 == 0) {
                j = j + 3;
            }
            else {
                j = j - 1;
            }
            if (j < board.length) {
                board[i][j] = -1;
            }
            a = i;
            count++;
        }
    }


    /**
     * Returns the series # of the board size based on the series equations
     * provided in the paper.
     * 
     * @param boardSize
     *            the size of the board.
     * @return the index of the series under which the board size falls (1-8)
     */
    private static int getSeries(int boardSize) {
        if (boardSize % 6 == 0) {
            // series 1: x = f(x) / 6
            return 1;
        }
        else if ((boardSize - 1) * 1.0 % 6 == 0) {
            // series 2: x = f(x) / 6 - 1
            return 2;
        }
        else if ((boardSize - 4) * 1.0 % 6 == 0) {
            // series 3: x = f(x) / 6 - 4
            return 3;
        }
        else if ((boardSize - 5) * 1.0 % 6 == 0) {
            // series 3: x = f(x) / 6 - 5
            return 4;
        }
        else if ((boardSize - 8) * 1.0 % 12 == 0) {
            // series 3: x = f(x) / 12 - 8
            return 5;
        }
        else if ((boardSize - 9) * 1.0 % 12 == 0) {
            // series 3: x = f(x) / 12 - 9
            return 6;
        }
        else if ((boardSize - 14) * 1.0 % 12 == 0) {
            // series 3: x = f(x) / 12 - 14
            return 7;
        }
        else if ((boardSize - 15) * 1.0 % 12 == 0) {
            // series 3: x = f(x) / 12 - 15
            return 8;
        }
        // should not occur
        return -1;
    }

}
