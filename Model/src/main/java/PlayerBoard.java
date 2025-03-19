import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class PlayerBoard {
    // Attributi privati
    private int numRows;
    private int numColumns;
    private Tile[][] matrixBoard;
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
    public void checkBoard(){
        //implementare
    }
    public double checkFirePower(){
        double power = 0; //solo per non fare errore
        //implementare
        return power;
    }
    public int checkHeaterPower(){
        int power = 0; //solo per non fare errore
        //implementare
        return power;
    }
    public int checkPassangersPower(){
        int power = 0; //solo per non fare errore
        //implementare
        return power;
    }
    public void modifyPassengerPower(int passengerLoss){
        passengersPower = passengersPower - passengerLoss;
    }
    public int checkCabinConnection() { //conta quante HousingUnit sono connesse direttamente tra loro
        int connection=0;
        //implementare
        return connection;
    }
    public void checkStorage(List<Integer> load){
        int size=load.size();
        int row;
        int col;
        int k;
        while(load.size()>0){
            while( load.size()==size ){
                for(row=0; row<numRows;row++){
                    for(col=0; col<numColumns; col++){
                        Tile tile = matrixBoard[row][col];
                        if(tile instanceof Storage){
                            int currentCapacity=((Storage)tile).checkCapacity();
                            if(currentCapacity>0){
                                if(((Storage)tile).addCargo(load.get(0))){
                                    load.remove(0);
                                }
                            }
                            else{
                                Collections.sort(((Storage)tile).getCargoValues());
                                if(((Storage)tile).getCargoValues().get(0)<load.get(0)) {
                                    ((Storage)tile).removeCargo(((Storage)tile).getCargoValues().get(0));
                                    ((Storage)tile).addCargo(load.get(0));
                                    load.remove(0);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}

