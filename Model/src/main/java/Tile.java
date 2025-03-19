public class Tile {
    public int row;
    public int column;
    private PlayerBoard playerBoard;
    public int[] connectors;

    public Tile(int[] connectors, int row, int column, PlayerBoard playerBoard) {
        this.connectors = connectors;
        this.row = row;
        this.column = column;
        this.playerBoard = playerBoard;
    }

    public int[] getConnectors()
    {
        return this.connectors;
    }


    public void reserveTile() {
        // Implementazione per riservare la tile
    }

    public void rotateTile() {
        // Implementazione per ruotare la tile
    }

    public boolean checkCell() {
        // Implementazione per controllare la cella
        return false;
    }

    public void removeTile() {
        // Implementazione per rimuovere la tile
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
        return column;
    }

    public void setCol(int column) {
        this.column = column;
    }
}
