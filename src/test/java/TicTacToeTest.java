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
}


