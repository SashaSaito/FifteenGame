import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        do {
            Collections.shuffle(tiles);
        } while (!isSolvable(tiles, getGoalState(), 4));

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = tiles.get(index++);
            }
        }
    }

    private List<Integer> getGoalState() {
        List<Integer> goal = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            goal.add(i);
        }
        goal.add(0);
        return goal;
    }

    private int inversions(List<Integer> list) {
        int inversions = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int n = list.get(i);
            if (n <= 1) {
                continue;
            }
            for (int j = i + 1; j < size; j++) {
                int m = list.get(j);
                if (m > 0 && n > m) {
                    inversions++;
                }
            }
        }
        return inversions;
    }

    private boolean isSolvable(List<Integer> start, List<Integer> goal, int width) {
        int startInversions = inversions(start);
        int goalInversions = inversions(goal);
        if (width % 2 == 0) {
            int goalZeroRow = goal.indexOf(0) / width;
            int startZeroRow = start.indexOf(0) / width;
            if (goalInversions % 2 == 0) {
                return startInversions % 2 == (goalZeroRow + startZeroRow) % 2;
            } else {
                return startInversions % 2 != (goalZeroRow + startZeroRow) % 2;
            }
        } else {
            return startInversions % 2 == goalInversions % 2;
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
