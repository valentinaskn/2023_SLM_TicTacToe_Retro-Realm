import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for the Player class in a Tic-Tac-Toe game.
 */
public class PlayerTest {

    /**
     * Test that verifies the getMarker method returns the correct marker.
     * This is a positive test case where we expect to get the exact marker
     * that was set for the player.
     */
    @Test
    public void testGetMarkerPositive() {
        char expectedMarker = 'X';
        Player player = new Player(expectedMarker);
        char actualMarker = player.getMarker();
        assertEquals("getMarker should return the correct marker 'X'.", expectedMarker, actualMarker);
    }

    /**
     * Test that verifies the getMarker method does not return a marker
     * that wasn't set for the player. This is a negative test case to ensure
     * that the getMarker method does not return incorrect data.
     */
    @Test
    public void testGetMarkerNegative() {
        char setMarker = 'O';
        char notExpectedMarker = 'X'; // This is not the marker we set for the player
        Player player = new Player(setMarker);
        char actualMarker = player.getMarker();
        assertNotEquals("getMarker should not return a marker other than 'O'.", notExpectedMarker, actualMarker);
    }
}
