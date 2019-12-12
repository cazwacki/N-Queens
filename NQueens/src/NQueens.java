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

    private static int boardSize;


    /**
     * Executes each method to solving the N-Queens problem.
     * 
     * @param args
     *            The list of arguments when executing the program.
     */
    public static void main(String[] args) {
        for(boardSize = 8; boardSize < 20; boardSize++) {
            System.out.println("Board Size is " + boardSize);
            SeriesAlg.solve(boardSize);
        }
    }

}
