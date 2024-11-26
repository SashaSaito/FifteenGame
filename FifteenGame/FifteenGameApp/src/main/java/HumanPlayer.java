import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void move(int[][] board) {
        System.out.println("Введіть номер фішки для переміщення:");
        int tile = scanner.nextInt();

        int tileRow = -1, tileCol = -1, emptyRow = -1, emptyCol = -1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == tile) {
                    tileRow = i;
                    tileCol = j;
                } else if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }

        if ((Math.abs(tileRow - emptyRow) == 1 && tileCol == emptyCol) ||
                (Math.abs(tileCol - emptyCol) == 1 && tileRow == emptyRow)) {
            board[emptyRow][emptyCol] = tile;
            board[tileRow][tileCol] = 0;
        } else {
            System.out.println("Неправильний хід. Спробуйте ще раз.");
        }
    }
}
