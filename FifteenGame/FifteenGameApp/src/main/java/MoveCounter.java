public class MoveCounter {
    private int moves;

    public MoveCounter() {
        this.moves = 0;
    }

    public void increment() {
        moves++;
    }

    public int getMoves() {
        return moves;
    }

    public void reset() {
        this.moves = 0;
    }
}
