import java.util.List;

public class AlienAddOn extends Tile {
    private AlienColor color; //PURPLE O BROWN

    // Costruttore
    public AlienAddOn(int[] connectors,int row, int column, PlayerBoard playerBoard, AlienColor color) {
        super(connectors, row, column, playerBoard);
        this.color = color;
    }

    public AlienColor getColor() {
        return this.color;
    }

    public int[] getSides() {
        return this.connectors;
    }
}
