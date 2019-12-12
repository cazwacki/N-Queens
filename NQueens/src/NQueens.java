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

    private static int boardSize = 21;


    /**
     * Executes each method to solving the N-Queens problem.
     * 
     * @param args
     *            The list of arguments when executing the program.
     */
    public static void main(String[] args) {
        System.out.println("Board Size is " + boardSize);
        int[][] sAlgBoard = SeriesAlg.solve(boardSize);
        
    }

}
