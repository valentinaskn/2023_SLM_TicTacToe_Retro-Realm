import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * A class that represents a Tic-Tac-Toe game.
 * The class contains a Board object and two Player objects. The class also
 * contains a Player object that represents the current player. The class
 * contains methods to start the game, switch the current player, and check
 * for a winner.
 */

public class TicTacToe {

    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    /**
     * The main method that starts the Tic-Tac-Toe game.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueGame = true;

        while(continueGame) {
            TicTacToe game = new TicTacToe();
            game.start();

            System.out.println("Do you want to play another game? (yes/no)");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("no")) {
                continueGame = false;
            }
        }

        System.out.println("Game over!");
        scanner.close();
    }

    private final Board board;

    /**
     * Gets the current player in the Tic-Tac-Toe game.
     *
     * @return The current player.
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    /**
     * Gets the game board.
     *
     * @return The game board.
     */
    public Board getBoard() {
        return board;
    }

    /**
     * Constructs a new Tic-Tac-Toe game.
     * The constructor initializes the game board and the two players.
     * The constructor also sets the current player to player1.
     */
    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

    /**
     * Starts the Tic-Tac-Toe game.
     * The method starts the game by printing a welcome message and then
     * looping until the game ends. In each iteration of the loop, the
     * method prints the current player, prints the board, gets valid
     * input from the user, and checks for a winner or draw. If the game
     * ends, the method prints the final board state and a message
     * indicating the winner or draw.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tic Tac Toe Game Started!");
        boolean gameEnded = false;

        while (!gameEnded) {
            // Print the current player
            System.out.println("Current Player: " + currentPlayer.getMarker());
            // Print the board
            board.print();

            boolean validInput = false;
            int row;
            int col;

            // Get valid input from user
            while (!validInput) {
                while(true) {
                    try {
                        System.out.print("row (0-2): ");
                        row = scanner.nextInt();
                        System.out.print("column (0-2): ");
                        col = scanner.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Use numbers (0-2).");
                        scanner.nextLine(); //clear input
                    }
                }
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board.isCellEmpty(row, col)) {
                    board.place(row, col, currentPlayer.getMarker());
                    validInput = true;
                } else {
                    System.out.println("Invalid input. Try again.");
                }

                // Check for win or draw
                if (hasWinner()) {
                    gameEnded = true;
                    // Print the winner's board state
                    System.out.println("Current Player: " + currentPlayer.getMarker());
                    board.print();
                    System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                } else if (board.isFull()) {
                    gameEnded = true;
                    board.print();
                    System.out.println("The game ended in a draw!");
                } else {
                    // Switch the current player
                    switchCurrentPlayer();
                }
            }
        }
    }
    /**
     * Switches the current player in the Tic-Tac-Toe game.
     * The method toggles between two players, changing the current player from player1
     * to player2 or vice versa. This allows the game to alternate turns between the
     * two players during each move.
     */
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Checks if there is a winner in the Tic-Tac-Toe game.
     * The method examines the rows, columns, and diagonals of the game board to determine
     * if a player has achieved a winning combination.
     *
     * @return true if there is a winner, false otherwise
     */
    public boolean hasWinner() {
        char[][] cells = board.cells;

        // Check rows for a win
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] != '\u0000' && cells[i][0] == cells[i][1] && cells[i][0] == cells[i][2]) {
                return true;
            }
        }

        // Check columns for a win
        for (int j = 0; j < 3; j++) {
            if (cells[0][j] != '\u0000' && cells[0][j] == cells[1][j] && cells[0][j] == cells[2][j]) {
                return true;
            }
        }

        // Check diagonals for a win
        if (cells[0][0] == '\u0000' || cells[0][0] != cells[1][1] || cells[0][0] != cells[2][2]) {
            return cells[0][2] != '\u0000' && cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0];

            // No winner found
        } else {
            return true;
        }
    }
}
