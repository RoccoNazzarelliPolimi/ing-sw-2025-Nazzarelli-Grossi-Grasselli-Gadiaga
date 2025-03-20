import java.util.List;

public class AlienAddOn extends Tile {
    private AlienColor color; //PURPLE O BROWN

    // Costruttore
    public AlienAddOn(int[] connectors,int row, int column, PlayerBoard playerBoard, AlienColor color) {
        super(connectors, row, column, playerBoard);
        this.color = color;
    }


    public void accept(TileVisitor visitor) {
        visitor.visit(this);
    }

    public AlienColor getColor() {
        return this.color;
    }

    public int[] getConnectors() {
        return this.connectors;
    }
}
