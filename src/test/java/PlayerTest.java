import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Player class in a Tic-Tac-Toe game.
 */
public class PlayerTest {

    /**
     * Test that verifies the getMarker method returns the correct marker.
     *
     */
    @Test
    public void testGetMarkerPositive() {
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);
        char actualMarker = player.getMarker();
        assertEquals(expectedMarker, actualMarker);
    }

    /**
     * Test that verifies the getMarker method does not return a marker
     * other than the one we set for the player.
     */
    @Test
    public void testGetMarkerNegative() {
        char setMarker = 'O';
        char notExpectedMarker = 'X'; // This is not the marker we set for the player
        Player player = new Player(setMarker);
        char actualMarker = player.getMarker();
        assertNotEquals(notExpectedMarker, actualMarker);
    }
}
