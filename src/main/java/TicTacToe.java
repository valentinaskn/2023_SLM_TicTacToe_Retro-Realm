import java.util.Scanner;
public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.start();
    }

    private Board board;
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }

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
            int row = -1;
            int col = -1;

            // Get valid input from user
            while (!validInput) {
                System.out.print("row (0-2): ");
                row = scanner.nextInt();
                System.out.print("column (0-2): ");
                col = scanner.nextInt();
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
     *
     * The method toggles between two players, changing the current player from player1
     * to player2 or vice versa. This allows the game to alternate turns between the
     * two players during each move.
     */
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Checks if there is a winner in the Tic-Tac-Toe game.
     *
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
        if (cells[0][0] != '\u0000' && cells[0][0] == cells[1][1] && cells[0][0] == cells[2][2]) {
            return true;
        }
        if (cells[0][2] != '\u0000' && cells[0][2] == cells[1][1] && cells[0][2] == cells[2][0]) {
            return true;
        }

        // No winner found
        return false;
    }
}
