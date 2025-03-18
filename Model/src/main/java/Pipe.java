public class Pipe extends Tile {
    private int[] sides;

    // Costruttore
    public Pipe(int[] sides, int connectorType) {
        this.sides = new int[3];;
    }

    // Getter per i lati della Pipe
    public int[] getSides() {
        return sides;
    }
}
