public class FourMoveBoard implements PredefinedBoard {
    @Override
    public int[][] getBoard() {
        return new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 0, 14, 15}
        };
    }
}
