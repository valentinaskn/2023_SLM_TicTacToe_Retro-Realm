/**
 * The Player class represents a player in a Tic-Tac-Toe game.
 * Each player is associated with a marker ('X' or 'O') on the game board.
 */
public class Player {

    /** The marker (symbol) assigned to the player ('X' or 'O'). */
    protected char marker;

    /**
     * Constructs a new Player instance with the specified marker.
     *
     * @param marker The marker assigned to the player ('X' or 'O').
     */
    public Player(char marker) {
        this.marker = marker;
    }

    /**
     * Gets the marker assigned to the player.
     *
     * @return The marker ('X' or 'O') associated with the player.
     */
    char getMarker() {
        return marker;
    }
}


