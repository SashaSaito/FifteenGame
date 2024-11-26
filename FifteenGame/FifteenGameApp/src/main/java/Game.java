public interface Game {
    int[][] board = new int[4][4];
    boolean validate();
    int[][] getBoard();
}
