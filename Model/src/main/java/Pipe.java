public class Pipe extends Tile {

    // Costruttore
    public Pipe(int[] connectors, int row, int column, PlayerBoard playerBoard) {
        super(connectors, row, column, playerBoard);
    }

    // Getter per i lati della Pipe
    public int[] getSides() {
        return this.connectors;
    }

    public void accept(TileVisitor visitor) {
        visitor.visit(this);
    }
}
