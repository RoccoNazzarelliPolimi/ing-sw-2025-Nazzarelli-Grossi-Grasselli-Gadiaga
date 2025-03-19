import java.util.List;

public class AlienAddOn extends Tile {
    private int[] sides;
    private AlienColor color; //PURPLE O BROWN

    // Costruttore
    public AlienAddOn(int row, int column, PlayerBoard playerBoard) {
        super(row, column, playerBoard);
        this.sides = new int[3];;
        this.color = color;
    }

    public AlienColor getColor() {
        return color;
    }

    public int[] getSides() {
        return sides;
    }
}
