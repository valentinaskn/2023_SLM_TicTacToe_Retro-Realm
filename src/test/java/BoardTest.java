import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Board class.
 */
public class BoardTest {

    /**
     * Test case: isEmptyCell should return true for an empty cell.
     */
    @Test
    public void isEmptyCell_shouldReturnTrueForEmptyCell() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    /**
     * Test case: isEmptyCell should return false for a non-empty cell.
     */
    @Test
    public void isEmptyCell_shouldReturnFalseForNonEmptyCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0));
    }

    /**
     * Test case: place should mark a cell correctly.
     */
    @Test
    public void place_shouldMarkCellCorrectly() {
        Board board = new Board();
        board.place(0, 0, 'X');
        assertEquals('X', board.cells[0][0]);
    }

    /**
     * Test case: place should not override an existing marker.
     */
    @Test
    public void place_shouldNotOverrideExistingMarker() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertNotEquals('O', board.cells[0][0]);
        assertEquals('X', board.cells[0][0]);
    }

    /**
     * Test case: isFull should return true for a full board.
     */
    @Test
    public void isFull_shouldReturnTrueForFullBoard() {
        Board board = new Board();
        char[] markers = {'X', 'O'};
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                board.place(i, j, markers[(i + j) % 2]);
            }
        }
        assertTrue(board.isFull());
    }

    /**
     * Test case: isFull should return false for an empty board.
     */
    @Test
    public void isFull_shouldReturnFalseForEmptyBoard() {
        Board board = new Board();
        assertFalse(board.isFull());
    }

    /**
     * Test case: clear should empty all cells on the board.
     */
    @Test
    public void clear_shouldEmptyAllCells() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
    }

    /**
     * Test case: clear should not leave any non-empty cell on the board.
     */
    @Test
    public void clear_shouldNotLeaveAnyNonEmptyCell() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.clear();

        boolean atLeastOneNonEmptyCell = false;
        for (int i = 0; i < board.cells.length; i++) {
            for (int j = 0; j < board.cells[i].length; j++) {
                if (board.cells[i][j] != '\u0000') {
                    atLeastOneNonEmptyCell = true;
                    break;
                }
            }
        }
        assertFalse(atLeastOneNonEmptyCell);
    }
}
