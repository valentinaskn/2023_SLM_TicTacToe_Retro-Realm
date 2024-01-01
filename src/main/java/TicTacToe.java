import java.util.Scanner;
public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public static void main(String[] args) {

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
            }
        }
    }
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    public boolean hasWinner() {
        return false;
    }
}
