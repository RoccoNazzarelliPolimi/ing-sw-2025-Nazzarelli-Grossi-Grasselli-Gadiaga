import java.util.Optional;

public class Cell {
    private int row;
    private int column;
    private Tile tile;
    private PlayerBoard playerBoard;

    // Costruttore
    public Cell(int row, int column, PlayerBoard playerBoard) {
        this.row = row;
        this.column = column;
        this.playerBoard = playerBoard;
        this.tile = null; // All'inizio la cella è vuota
    }

    // Metodo per ottenere le coordinate come stringa
    public int[] getCoordinates() {
        return new int[]{row, column};
    }

    // Ritorna Tile se c'è, se non c'è ritorna empty
    public Optional<Tile> checkTileOptional() {
        return Optional.ofNullable(tile);
    }

    //Rimuovo una Tile
    public void removeTile() {
        if (this.tile != null) {
            this.tile.setCell(null); // Rimuove la Cell dalla Tile
            this.tile = null; // Rimuove la Tile dalla Cell
        }
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
    public Tile getTile() {
        return tile;
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }
}
