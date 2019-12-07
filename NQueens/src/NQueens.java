/**
 * The NQueens class calculates valid n-queens problems up to a specified size.
 * It uses different methods and calculates the speed of each one, noting the
 * efficiency and number of discovered solutions to note whether some algorithms
 * omit solutions or not.
 * 
 * @author Charles Zawacki
 * @version 12/6/2019
 *
 */
public class NQueens {

    private static Queen[] queens;
    private static int boardSize;


    /**
     * The reset() function renders the board empty so it can be used again for
     * calculation. Should be used between finding solutions.
     */
    private static void reset() {
        for (int i = 0; i < queens.length; i++) {
            queens[i] = null;
        }
    }


    /**
     * Executes each method to solving the N-Queens problem.
     * 
     * @param args
     *            The list of arguments when executing the program.
     */
    public static void main(String[] args) {
        boardSize = 3;
    }


    /**
     * A brute force solution to the N-Queens problem. It places all queens in
     * every possible location without checking for safety, then evaluates the
     * entire board for whether it is a valid solution to the n-queens problem.
     * 
     * @param printSolutions
     *            If printSolutions is true, then every valid solution found by
     *            the method will be printed to console.
     */
    private static void bruteForce(boolean printSolutions) {
        for (int row1 = 0; row1 < boardSize; row1++) {

        }
    }


    /**
     * A utility function to check if a queen can
     * be placed on board[row][col]. Note that this
     * function is called when "col" queens are already
     * placeed in columns from 0 to col -1. So we need
     * to check only left side for attacking queens
     */
    private static boolean validSolution() {
        // for each queen in the array
        for (int a = 0; a < boardSize; a++) {
            // for each queen after queen a
            for (int b = a + 1; b < boardSize; b++) {
                // Check if queens are on the same row.
                if (queens[a].getRow() == queens[b].getRow()) {
                    return false;
                }

                // Check if queens are on the same column.
                if (queens[a].getColumn() == queens[b].getColumn()) {
                    return false;
                }

                /*
                 * Check if queens are on the same diagonal line.
                 * This is verified by calculating the slope of the line
                 * connecting the two queens. If the slope is 1, then the queens
                 * are on the same diagonal line.
                 */
                int colDiff = queens[a].getColumn() - queens[b].getColumn();
                int rowDiff = queens[a].getRow() - queens[b].getRow();
                if (colDiff * 1.0 / rowDiff != 1) {
                    return false;
                }
            }
        }
        // return true if none of the above conditions are met.
        return true;
    }

}
