public class FiveMoveBoard implements PredefinedBoard {
    @Override
    public int[][] getBoard() {
        return new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {0, 13, 14, 15}
        };
    }
}