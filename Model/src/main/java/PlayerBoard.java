import java.util.ArrayList;
import java.util.List;

public class PlayerBoard {
    private int numRows;
    private int numColumns;
    private Tile[][] matrixBoard; //userei 13 come numero per dire che la cella non è valida
    private Player player;
    private int firePowerPlayer;
    private int heaterPowerPlayer;
    private int passengersPower;
    private int numberTile; //Potrebbe non servire questo attributo
    private int numberDeletedTile;
    private Tile[] stock;

    // Costruttore
    public PlayerBoard(int numRows, int numColumns, Player player, int stockSize) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.matrixBoard = new Tile[numRows][numColumns];
        this.player = player;
        this.firePowerPlayer = 0;
        this.heaterPowerPlayer = 0;
        this.passengersPower = 0;
        this.numberTile = 0;
        this.numberDeletedTile = 0;
        this.stock= new Tile[stockSize];
    }

    // Metodo per ottenere una cella dalle coordinate
    public Tile getTileAt(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && row != 13 && col != 13) {
            return matrixBoard[row][col]; // Restituisce la Tile nella posizione specificata
        }
        return null; // Nessuna Tile trovata con quelle coordinate
    }

    // Metodo per aggiungere una tessera
    public void addTile(Tile tile, int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && matrixBoard[row][col] == null) {
            matrixBoard[row][col] = tile;
            numberTile++;
        }
    }

    // Metodo per rimuovere una tessera (anche su Tile)
    public void removeTile(int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && row != 13 && col != 13 && matrixBoard[row][col] != null) {
            Tile tileToRemove = matrixBoard[row][col];

            // Rimuoviamo il riferimento alla Tile dalla matrice
            matrixBoard[row][col] = null;

            // Aggiorniamo i riferimenti dentro Tile
            if (tileToRemove != null) {
                tileToRemove.setRow(-1); // Segniamo la Tile come "non piazzata"
                tileToRemove.setCol(-1);
                tileToRemove.setPlayerBoard(null); // Rimuoviamo il riferimento alla PlayerBoard
            }

            numberTile--; // Decrementiamo il numero di Tile attive
            numberDeletedTile++; // Aumentiamo il numero di Tile rimosse
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

    //Metodo che controlla se, finita la costruzione della nave, è giusta
    public int checkBoard() {
        //implementazione
    }

    public int getNumRows() {
        return numRows;
    }
    public int getNumColumns() {
        return numColumns;
    }

    //metodi check? (power, passengers, heater)
}

