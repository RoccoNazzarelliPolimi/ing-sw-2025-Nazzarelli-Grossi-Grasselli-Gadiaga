public class Pipe extends Tile {
    private int[] sides;

    // Costruttore
    public Pipe(int[] sides, int connectorType) {
        this.sides = sides;
    }

    // Metodo per ottenere il tipo di Tile
    public String CheckTypeTile() {
        return "Pipe";
    }

    // Getter per i lati della Pipe
    public int[] getSides() {
        return sides;
    }
}
