import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FifteenGame implements Game {
    private int[][] board;

    public FifteenGame() {
        this.board = new int[4][4];
        initializeBoard();
        shuffleBoard();
    }

    private void initializeBoard() {
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (counter <= 15) {
                    board[i][j] = counter++;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void shuffleBoard() {
        List<Integer> tiles = new ArrayList<>();

        for (int i = 1; i <= 15; i++) {
            tiles.add(i);
        }
        tiles.add(0);

        Collections.shuffle(tiles);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = tiles.get(index++);
            }
        }
    }

    @Override
    public boolean validate() {
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == 3 && j == 3 && board[i][j] == 0) return true;
                if (board[i][j] != counter++) return false;
            }
        }
        return true;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
