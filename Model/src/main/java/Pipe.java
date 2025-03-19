public class Pipe extends Tile {
    private int[] sides;

    // Costruttore
    public Pipe(int row, int column, PlayerBoard playerBoard) {
        super(row, column, playerBoard);
        this.sides = new int[3];
    }

    // Getter per i lati della Pipe
    public int[] getSides() {
        return sides;
    }
}
