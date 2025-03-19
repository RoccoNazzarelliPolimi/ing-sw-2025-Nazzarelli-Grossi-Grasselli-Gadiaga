public class Shield extends Tile {
    private int[] sides;
    private int[] defence; // 1 = scudo attivo su quel lato, 0 = nessuno scudo

    // Costruttore
    public Shield(int row, int column, PlayerBoard playerBoard) {
        super(row, column, playerBoard);
        this.sides = new int[3];;
        this.defence = new int[3];;
    }

    // Metodo per ottenere i lati protetti dallo scudo
    public int[] getDefence() {
        return defence;
    }

    public int[] getSides() {
        return sides;
    }
}

