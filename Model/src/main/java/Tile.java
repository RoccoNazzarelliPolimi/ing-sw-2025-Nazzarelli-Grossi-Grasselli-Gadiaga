public  class Tile {
    private Cell cell;

    // Costruttore
    public Tile() {
    }

    // Metodo per riservare un Tile (metterla a lato)
    public void reserveTile() {
        // Implementazione?
    }

    // Metodo per ruotare un Tile
    public void rotateTile() {
        // Implementazione
    }

    // Metodo per controllare la cella (se la cella è piena o si può mettere la tile)
    public void checkCell() {
        // Implementazione
    }

    //Avendo una tile, ritorna le coordinate della cella
    public int[] getCoordinates() {
        if (cell != null) {
            return cell.getCoordinates(); // Restituisce l'array [row, column]
        } else {
            return null; // Nessuna cella assegnata
        }
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    // Tolgo la tile dalla cella e la metto nello stock
    public void removeTile(PlayerBoard board) {
        this.cell = null; // La tile non ha più una cella assegnata
        // Mettere qualcosa che aggiunge la Tile allo stock (come ReserveTile)
    }

}
