/**
 * Queen is a container class holding an row and column position.
 * 
 * @author Charles Zawacki
 * @version 12/7/2019
 *
 */
public class Queen {

    private int row;
    private int column;


    /**
     * The constructor creates a new Queen with a user-provided row and column
     * position.
     * 
     * @param row
     *            the row on which the queen will be located.
     * @param column
     *            the column on which the queen will be located.
     */
    public Queen(int row, int column) {
        this.row = row;
        this.column = column;
    }


    /**
     * Returns the Queen's row position.
     * 
     * @return the row on which the queen is located.
     */
    public int getRow() {
        return row;
    }


    /**
     * Sets the Queen's row to a new row.
     * 
     * @param row
     *            the new row where the Queen will be located.
     */
    public void setRow(int row) {
        this.row = row;
    }


    /**
     * Returns the Queen's column position.
     * 
     * @return the column on which the queen is located.
     */
    public int getColumn() {
        return column;
    }


    /**
     * Sets the Queen's column to a new column.
     * 
     * @param column
     *            the new column where the Queen will be located.
     */
    public void setColumn(int column) {
        this.column = column;
    }

}
