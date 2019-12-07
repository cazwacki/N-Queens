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

    private static boolean[][] board;
    // "true" means that there is a queen in the given position.


    /**
     * The toggle() function toggles the boolean at the given index (ex. true ->
     * false, false -> true).
     * 
     * @param column
     *            the column on the chessboard where the boolean is located.
     * @param row
     *            the row on the chessboard where the boolean is located.
     */
    private static void toggle(int column, int row) {
        board[column][row] = !board[column][row];
    }


    /**
     * The reset() function renders the board empty so it can be used again for
     * calculation. Should be used between finding solutions.
     */
    private static void reset() {
        for (boolean[] row : board) {
            for (boolean entry : row) {
                entry = false;
            }
        }
    }


    /**
     * Executes each method to solving the N-Queens problem.
     * 
     * @param args
     *            The list of arguments when executing the program.
     */
    public static void main(String[] args) {
        board = new boolean[3][3];
    }

}
