import java.util.Optional;

public class Cell {
    private int row;
    private int column;
    private Tile tile;
    private PlayerBoard playerBoard; //PlayerBoard ancora non definita

    // Costruttore
    public Cell(int row, int column, PlayerBoard playerBoard) {
        this.row = row;
        this.column = column;
        this.playerBoard = playerBoard;
        this.tile = null; // All'inizio la cella è vuota
    }

    // Metodo per ottenere le coordinate come stringa
    public int[] GetCoordinates() {
        return new int[]{row, column};
    }

    // Ritorna Tile se c'è, se non c'è ritorna empty
    public Optional<Tile> CheckTileOptional() {
        return Optional.ofNullable(tile);
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public PlayerBoard getPlayerBoard() {
        return playerBoard;
    }

    public void setPersonalBoard(PlayerBoard personalBoard) {
        this.playerBoard = personalBoard;
    }
}
