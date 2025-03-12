import java.util.ArrayList;
import java.util.List;

public class PlayerBoard {
    // Attributi privati
    private int numRows;
    private int numColumns;
    private Tile[][] matrixBoard;
    private List<Cell> allCells; // Lista di tutte le celle
    private Player player;
    private int firePowerPlayer;
    private int passengersPower;
    private int numberTile;
    private Tile[] stockInitialArray;

    // Costruttore
    public PlayerBoard(int numRows, int numColumns, Player player, int stockSize) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.matrixBoard = new Tile[numRows][numColumns];
        this.player = player;
        this.firePowerPlayer = 0;
        this.passengersPower = 0;
        this.numberTile = 0;
        this.stockInitialArray = new Tile[stockSize];

    }

    // Metodo per ottenere una cella dalle coordinate
    public Cell getCellAt(int row, int col) {
        for (Cell cell : allCells) {
            if (cell.getCoordinates()[0] == row && cell.getCoordinates()[1] == col) {
                return cell; // Restituisce la cella trovata
            }
        }
        return null; // Nessuna cella trovata con quelle coordinate
    }

    public List<Cell> getAllCells() {
        return new ArrayList<>(allCells); // Restituisce una copia della lista
    }


    // Metodo per aggiungere una tessera
    public void addTile(Tile tile, int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && matrixBoard[row][col] == null) {
            matrixBoard[row][col] = tile;
            numberTile++;
        }
    }

    // Metodo per rimuovere una tessera
    public void removeTile(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && matrixBoard[row][col] != null) {
            matrixBoard[row][col] = null;
            numberTile--;
        }
    }

    // Metodo per contare i lati vuoti
    public int countEmptySides() {
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrixBoard[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    // Metodo per contare i connettori aperti
    public int countOpenConnectors() {
        int count = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrixBoard[i][j] != null) {
                    //count += matrixBoard[i][j].getOpenConnectors();
                }
            }
        }
        return count;
    }
}

