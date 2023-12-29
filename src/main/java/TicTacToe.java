public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    public static void main(String[] args) {

    }

    public TicTacToe() {
        board = new Board();
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
    }
    public void start() {

    }
    public void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    public boolean hasWinner() {
        return true;
    }
}
