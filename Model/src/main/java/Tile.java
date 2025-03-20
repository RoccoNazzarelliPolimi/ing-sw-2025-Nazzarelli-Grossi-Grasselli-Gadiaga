public class Tile {
    public int row;
    public int column;
    private PlayerBoard playerBoard;
    public int[] connectors; //[sx, up, dx, down]

    public Tile(int[] connectors, int row, int column, PlayerBoard playerBoard) {
        this.connectors = new int[4];
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

    //This rotates the tile towards the right n times
    //[sx, up, dx, down] → [down, sx, up, dx]
    public void rotateTile(int times) {
        times = times % 4;
        for (int i = 0; i < times; i++) {
            int temp = connectors[3]; //saving the last value

            connectors[3] = connectors[2]; // down ← dx
            connectors[2] = connectors[1]; // dx ← up
            connectors[1] = connectors[0]; // up ← sx
            connectors[0] = temp;          // sx ← down
        }
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
