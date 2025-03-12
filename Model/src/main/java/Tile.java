public  class Tile {
    private Cell cell; // La classe Cell ancora non esiste
    private int destroyed; //toglierei questo attributo!!

    // Serve un costruttore?

    // Metodo per verificare il tipo di Tile(lo faccio poi in ogni sottoclasse)
    // public abstract String CheckTypeTile();

    // Metodo per riservare un Tile (metterla a lato)
    public void ReserveTile() {
        // Implementazione?
    }

    // Metodo per ruotare un Tile
    public void RotateTile() {
        // Implementazione
    }

    // Metodo per controllare la cella (se la cella è piena o si può mettere la tile)
    public void CheckCell() {
        // Implementazione
    }

    // Nuovi metodi
    //Avendo una tile, ritorna le coordinate della cella
    public int[] getCell() {
        if (cell != null) {
            return cell.GetCoordinates(); // Restituisce l'array [row, column]
        } else {
            return null; // Nessuna cella assegnata
        }
    }

    //Settare l'attributo cella alla tile
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    // Tolgo la tile dalla cella e la metto nello stock
    public void removeTile(PlayerBoard board) {
        this.cell = null; // La tile non ha più una cella assegnata
        // Mettere qualcosa che aggiunge la Tile allo stock (come ReserveTile)
    }

}
