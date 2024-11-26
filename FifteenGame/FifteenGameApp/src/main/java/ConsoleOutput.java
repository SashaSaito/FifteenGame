public class ConsoleOutput implements Output {
    @Override
    public void visual(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 0 ? " " : cell) + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
