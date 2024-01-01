import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Unit tests for the TicTacToe class.
 */
public class TicTacToeTest {

    /**
     * Verifies that the switchCurrentPlayer method switches players correctly.
     */
    @Test
    public void switchCurrentPlayer_shouldSwitchPlayersCorrectly() {
        // Create a new TicTacToe game instance
        TicTacToe game = new TicTacToe();

        // Get the initial current player
        Player initialPlayer = game.getCurrentPlayer();

        // Call the switchCurrentPlayer method to switch the current player
        game.switchCurrentPlayer();

        // Get the player after the switch
        Player switchedPlayer = game.getCurrentPlayer();

        // Assert that the player has been switched
        assertNotEquals(initialPlayer, switchedPlayer);
    }

    /**
     * Test case: hasWinner should return true if Winner is found.
     */
    @Test
    public void hasWinner_shouldReturnTrueForWinner(){
        // Arrange

        TicTacToe ticTacToe = new TicTacToe();
        Board board = ticTacToe.getBoard();

        // Set up a winning scenario in a row
        board.cells[0][0] = 'X';
        board.cells[0][1] = 'X';
        board.cells[0][2] = 'X';

        // Act and Assert
        assertTrue(ticTacToe.hasWinner());
    }

    /**
     * Test case: hasWinner should return false if Game ends in a draw.
     */
    @Test
    public void hasWinner_shouldReturnFalseForNoWinner() {
        // Arrange
        TicTacToe ticTacToe = new TicTacToe();
        Board board = ticTacToe.getBoard();

        // Set up a scenario with no winner
        board.cells[0][0] = 'X';
        board.cells[0][1] = 'O';
        board.cells[0][2] = 'X';
        board.cells[1][0] = 'X';
        board.cells[1][1] = 'X';
        board.cells[1][2] = 'O';
        board.cells[2][0] = 'O';
        board.cells[2][1] = 'X';
        board.cells[2][2] = 'O';

        // Act and Assert
        assertFalse(ticTacToe.hasWinner());
    }
}


