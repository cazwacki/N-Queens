/**
 * The NQueens class calculates valid n-queens problems up to a specified size.
 * It uses the series methods and notes the analysis of each board.
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
