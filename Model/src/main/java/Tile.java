public  class Tile {
    public int row;
    public int col;
    private PlayerBoard playerBoard;

    // Costruttore
    public Tile() {
        this.row = -1; // Indica che la Tile non è ancora piazzata
        this.col = -1;
    }

    // Metodo per ottenere le coordinate come stringa
    public int[] getCoordinates() {
        if (this.row == -1 || this.col == -1) {
            return null; // La Tile non è piazzata, quindi restituisce null
        }
        return new int[]{row, col}; // Restituisce le coordinate se la Tile è piazzata
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

    // Tolgo la tile dalla cella e la metto nello stock
    public void removeTile(PlayerBoard board) {
        this.playerBoard = null; // La tile non ha più una PB assegnata
        // Mettere qualcosa che aggiunge la Tile allo stock (come ReserveTile)
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }

    public void setPlayerBoard(PlayerBoard playerBoard) {
        this.playerBoard = playerBoard;
    }
    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }
    public void setCol(int col) {
        this.col = col;
    }
}
