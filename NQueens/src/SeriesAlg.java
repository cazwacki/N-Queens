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

    private int[][] board;
    private int boardSize;


    /**
     * Rule 1 is executed when the size of the board falls under one of the
     * following series: {S2, S4}
     */
    private void rule1() {
        // increase the dimension of the chess board by one (row + 1, column +
        // 1)

        // call analyzer function with the updated dimensions

        // place a queen where position(x, y) = 0
    }


    /**
     * Rule 2 is executed when the board falls within series S6.
     */
    private void rule2() {

    }


    /**
     * move1 increases the row value of the board by 3 and reduces the column
     * value by 1. The first queen's placement is dependent on the series under
     * which the board size falls.
     */
    private void move1(int i, int j) {
        board[i][j] = -1;
        for (int a = 1; a <= boardSize; a++) {
            i = i + 3;
            j = j - 1;
            board[i][j] = -1;
            a = i;
        }
    }


    /**
     * move2 increases the row value of the chess board by 2 and reduces the
     * column value by 1. The placement of the first queen is dependent on the
     * series under which the size of the chessboard falls.
     */
    private void move2(int i, int j) {
        board[i][j] = -1;
        for (int a = 1; a <= boardSize; a++) {
            i = i + 2;
            j = j + 1;
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
    private void move3(int i, int j) {
        int count = 0;
        board[i][j] = -1;
        for (int a = boardSize; a >= 1; a--) {
            i = i - 2;
            if (count % 2 == 0) {
                j = j + 3;
            }
            else {
                j = j - 1;
            }
            board[i][j] = -1;
            a = i;
            count++; // although not in the algorithm, it was probably omitted
                     // unintentionally.
        }
    }


    private void solve(int n) {
        this.boardSize = n;
        switch (getSeries(n)) {
            case 1:
                move1(1, n / 3);
                move1(2, n / 3 * 2);
                move1(3, n);
                break;
            case 2:
                break;
            case 3:
                move1(2, (n - 1) / 3);
                move1(1, ((n - 1) / 3) * 2 + 1);
                move1(3, n);
                break;
            case 4:
                break;
            case 5:
                move2(1, n / 2);
                move3(n, (n / 2) + 2);
                break;
            case 6:
                move2(2, (n - 1) / 2);
                move3(n, (n - 1) / 2 + 2);
                rule2();
                break;
            case 7:
                move2(1, (n / 2) + 1);
                move3(n, (n / 2) + 3);
                board[2][1] = -1;
                break;
            case 8:
                move2(1, (n - 1) / 2 + 2);
                move3(n, (n - 1) / 2 + 4);
                board[1][1] = -1;
                board[3][2] = -1;
                break;
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
    private int getSeries(int boardSize) {
        if (boardSize / 6 == 0) {
            // series 1: x = f(x) / 6
            return 1;
        }
        else if (boardSize / 6 - 1 == 0) {
            // series 2: x = f(x) / 6 - 1
            return 2;
        }
        else if (boardSize / 6 - 4 == 0) {
            // series 3: x = f(x) / 6 - 4
            return 3;
        }
        else if (boardSize / 6 - 5 == 0) {
            // series 3: x = f(x) / 6 - 5
            return 4;
        }
        else if (boardSize / 12 - 8 == 0) {
            // series 3: x = f(x) / 12 - 8
            return 5;
        }
        else if (boardSize / 12 - 9 == 0) {
            // series 3: x = f(x) / 12 - 9
            return 6;
        }
        else if (boardSize / 12 - 14 == 0) {
            // series 3: x = f(x) / 12 - 14
            return 7;
        }
        else if (boardSize / 12 - 15 == 0) {
            // series 3: x = f(x) / 12 - 15
            return 8;
        }
        // should not occur
        return -1;
    }

}
