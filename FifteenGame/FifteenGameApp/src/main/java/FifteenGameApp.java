import java.util.Scanner;

public class FifteenGameApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoveCounter moveCounter = new MoveCounter();
        Game game;
        Output output = new ConsoleOutput();
        Player player = new HumanPlayer();

        System.out.println("Оберіть тип дошки:");
        System.out.println("1. Випадкове розташування (default)");
        System.out.println("2. Легке (3 рухи)");
        System.out.println("3. Середнє (4 рухи)");
        System.out.println("4. Важке (5 рухів)");

        int choice = scanner.nextInt();
        switch (choice) {
            case 2 -> game = new FifteenGame(new ThreeMoveBoard().getBoard());
            case 3 -> game = new FifteenGame(new FourMoveBoard().getBoard());
            case 4 -> game = new FifteenGame(new FiveMoveBoard().getBoard());
            default -> game = new FifteenGame();
        }

        System.out.println("Ласкаво просимо до гри П'ятнашки!");

        while (!game.validate()) {
            output.visual(game.getBoard());
            player.move(game.getBoard());
            moveCounter.increment();
        }

        System.out.println("Вітаємо, ви виграли!");
        System.out.println("Кількість ходів: " + moveCounter.getMoves());
        output.visual(game.getBoard());
    }
}
