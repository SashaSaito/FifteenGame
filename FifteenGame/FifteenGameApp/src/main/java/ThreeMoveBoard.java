public class ThreeMoveBoard implements PredefinedBoard {
    @Override
    public int[][] getBoard() {
        return new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 0, 12},
                {13, 14, 11, 15}
        };
    }
}
