/**
 * Represents the game board for Tic-Tac-Toe.
 * The board is a 3x3 grid where players can place their markers ('X' or 'O').
 */
public class Board {

    /** The 3x3 grid to store markers ('X' or 'O'). */
    protected char[][] cells = new char[3][3];

    /**
     * Constructs a new empty board and initializes it by calling the clear method.
     */
    public Board() {
        clear();
    }

    /**
     * Checks if a specific cell on the board is empty.
     *
     * @param x The row index of the cell.
     * @param y The column index of the cell.
     * @return true if the cell is empty, false otherwise.
     */
    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\u0000';
    }

    /**
     * Places a marker on the specified cell if the cell is empty.
     *
     * @param x      The row index of the cell.
     * @param y      The column index of the cell.
     * @param marker The marker to be placed ('X' or 'O').
     */
    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    /**
     * Checks if the board is full, i.e., if all cells are occupied.
     *
     * @return true if the board is full, false otherwise.
     */
    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Clears the entire board by setting all cells to an empty state.
     */
    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '\u0000';
            }
        }
    }
    public void print() {

    }
}
