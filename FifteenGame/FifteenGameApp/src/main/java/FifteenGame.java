import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FifteenGame implements Game {
    private int[][] board;

    public FifteenGame() {
        this.board = new int[4][4];
        initializeBoard();
        shuffleBoard();
        while (!isSolvable(getFlatBoard(), getGoalState(), 4)) {
            shuffleBoard();
        }
    }

    public FifteenGame(int[][] predefinedBoard) {
        this.board = predefinedBoard;
    }

    private void initializeBoard() {
        int counter = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = (counter <= 15) ? counter++ : 0;
            }
        }
    }

    private void shuffleBoard() {
        List<Integer> tiles = getFlatBoard();
        Collections.shuffle(tiles);

        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = tiles.get(index++);
            }
        }
    }

    private List<Integer> getFlatBoard() {
        List<Integer> flatBoard = new ArrayList<>();
        for (int[] row : board) {
            for (int cell : row) {
                flatBoard.add(cell);
            }
        }
        return flatBoard;
    }

    private List<Integer> getGoalState() {
        List<Integer> goal = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            goal.add(i);
        }
        goal.add(0);
        return goal;
    }

    private boolean isSolvable(List<Integer> start, List<Integer> goal, int width) {
        return inversions(start) % 2 == inversions(goal) % 2;
    }

    private int inversions(List<Integer> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j) && list.get(j) != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean validate() {
        List<Integer> flat = getFlatBoard();
        return flat.equals(getGoalState());
    }

    @Override
    public int[][] getBoard() {
        return board;
    }
}
