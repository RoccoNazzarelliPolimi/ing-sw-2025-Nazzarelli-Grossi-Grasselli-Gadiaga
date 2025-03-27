public class Shield extends Tile {
    private int[] defence; // 1 = scudo attivo su quel lato, 0 = nessuno scudo

    // Costruttore
    public Shield(int[] connectors,int row, int column, PlayerBoard playerBoard, int[] defence) {
        super(connectors, row, column, playerBoard);
        this.defence = defence;
    }

    // Metodo per ottenere i lati protetti dallo scudo
    public int[] getDefence() {
        return defence;
    }

    public int[] getConnectors() {
        return this.connectors;
    }
}

