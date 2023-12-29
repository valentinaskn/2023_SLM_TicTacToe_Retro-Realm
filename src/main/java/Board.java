public class Board {
    protected char[][] cells = new char[3][3];

    public Board() {
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\u0000';
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char cell : row) {
                if (cell == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '\u0000';
            }
        }
    }

    public void print() {
        // Print the top border
        System.out.println("▁▁▁▁▁▁▁");

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print("|");
                // If the cell is empty, print a space, otherwise print the marker
                System.out.print(cells[i][j] == '\u0000' ? " " : cells[i][j]);
            }
            // Print the row end
            System.out.println("|");

        }

        // Print the bottom border
        System.out.println("▔▔▔▔▔▔▔");
    }
}
