public class FifteenGameApp {
    public static void main(String[] args) {
        Game game = new FifteenGame();
        Output output = new ConsoleOutput();
        Player player = new HumanPlayer();

        System.out.println("Ласкаво просимо до гри П'ятнашки!");

        while (!game.validate()) {
            output.visual(game.getBoard());
            player.move(game.getBoard());
        }

        System.out.println("Вітаємо, ви виграли!");
        output.visual(game.getBoard());
    }
}