import java.util.List;
import java.util.*;

public class PlayerBoard {
    // Attributi privati
    private int numRows;
    private int numColumns;
    private Tile[][] matrixBoard;
    private Player player;
    private double firePowerPlayer;
    private int passengersPower;
    private int numberTile;
    private int numberBatteries;
    private Tile[] stockInitialArray;
    private int heaterPowerPlayer;
    private int numberAliens;



    // Costruttore
    public PlayerBoard(int numRows, int numColumns, Player player) {
        this.numRows = numRows;
        this.numColumns = numColumns;
        this.matrixBoard = new Tile[numRows][numColumns];
        this.player = player;
        this.firePowerPlayer = 0;
        this.passengersPower = 0;
        this.numberTile = 0;
        this.numberBatteries = 0;
        this.heaterPowerPlayer = 0;
        this.numberAliens = 0;
        this.stockInitialArray = new Tile[2];
    }


    // Metodo per aggiungere una tessera
    public void addTile(Tile tile, int row, int col) {
        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && matrixBoard[row][col] == null) {
            if (row >= 4 && row <= 9 && col >= 3 && col <= 11) {
                if ((row!=4 && col!=3) && (row!=4 && col!=4) && (row!=4 && col!=5) && (row!=4 && col!=6) && (row!=4 && col!=8) && (row!=4 && col!=9) && (row!=4 && col!=10) && (row!=4 && col!=11) && (row!=5 && col!=3) && (row!=5 && col!=4) && (row!=5 && col!=5) && (row!=5 && col!=9) && (row!=5 && col!=10) && (row!=5 && col!=11) && (row!=6 && col!=3) && (row!=6 && col!=4) && (row!=6 && col!=10) && (row!=6 && col!=11) && (row!=7 && col!=3) && (row!=7 && col!=4) && (row!=7 && col!=10) && (row!=7 && col!=11) && (row!=8 && col!=3) && (row!=8 && col!=11) && (row!=9 && col!=11) && (row!=9 && col!=3) && (row!=9 && col!=7)) {
                    matrixBoard[row][col] = tile;
                    numberTile++;
                }
                else {
                    System.out.println("You are not allowed to insert a cell in that position!!!!");
                }
            } else {
                System.out.println("You are not allowed to insert a cell in that position!!!!");
            }
        }
    }



    // Metodo per rimuovere una tessera
    public void removeTile(int row, int col) {
        if(matrixBoard[row][col] != null) {
            matrixBoard[row][col] = null;
            numberTile--;
        } else {
            System.out.println("Tile Not Found");
        }
    }


    // Metodo per contare i connettori aperti
    public int countOpenConnectors() {
        int openConnectors = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrixBoard[i][j] != null) {
                    Tile currentTile = matrixBoard[i][j];
                    int[] connectors = currentTile.getConnectors();
                    //Sx check
                    if (j == 0 || matrixBoard[i][j - 1] == null) {
                        if (connectors[0] != 0) {
                            openConnectors++;
                        }
                    }
                    // Dx check
                    if (j == numColumns - 1 || matrixBoard[i][j + 1] == null) {
                        if (connectors[2] != 0) {
                            openConnectors++;
                        }
                    }
                    // Up check
                    if (i == 0 || matrixBoard[i - 1][j] == null) {
                        if (connectors[1] != 0) {
                            openConnectors++;
                        }
                    }
                    //Down check
                    if (i == numRows - 1 || matrixBoard[i + 1][j] == null) {
                        if (connectors[3] != 0) {
                            openConnectors++;
                        }
                    }
                }
            }
        }
        return openConnectors;
    }

    public boolean checkBoardConnections() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrixBoard[i][j] != null) {
                    Tile currentTile = matrixBoard[i][j];

                    // Controlla connettori a sinistra
                    if (j > 0 && matrixBoard[i][j - 1] != null) {
                        if (!this.matchesConnectorHor(matrixBoard[i][j - 1], currentTile)) {
                            System.out.println("Errore di connessione a sinistra per la tessera in posizione (" + i + ", " + j + ")");
                            deleteTile(currentTile, i, j);
                            return this.checkBoardConnections();
                        }
                    }

                    // Controlla connettori a destra
                    if (j < numColumns - 1 && matrixBoard[i][j + 1] != null) {
                        if (!this.matchesConnectorHor(currentTile, matrixBoard[i][j + 1])) {
                            System.out.println("Errore di connessione a destra per la tessera in posizione (" + i + ", " + j + ")");
                            deleteTile(currentTile, i, j);
                            return this.checkBoardConnections();
                        }
                    }

                    // Controlla connettori in alto
                    if (i > 0 && matrixBoard[i - 1][j] != null) {
                        if (!this.matchesConnectorVer(currentTile, matrixBoard[i - 1][j])) {
                            System.out.println("Errore di connessione in alto per la tessera in posizione (" + i + ", " + j + ")");
                            deleteTile(currentTile, i, j);
                            return this.checkBoardConnections();
                        }
                    }

                    // Controlla connettori in basso
                    if (i < numRows - 1 && matrixBoard[i + 1][j] != null) {
                        if (!this.matchesConnectorVer(matrixBoard[i + 1][j], currentTile)) {
                            System.out.println("Errore di connessione in basso per la tessera in posizione (" + i + ", " + j + ")");
                            deleteTile(currentTile, i, j);
                            return this.checkBoardConnections();
                        }
                    }
                }
            }
        }
    }


    // Metodo che elimina una tile quando non è connessa bene
    public void deleteTile(Tile tile, int row, int col) {
        if (matrixBoard[row][col] == null) return;

        matrixBoard[row][col] = null;
        this.player.addScore(-1);

        TileRemovalVisitor removalVisitor = new TileRemovalVisitor(this, this.player);
        tile.accept(removalVisitor);
    }

    public void decreaseFirePower(int amount) {
        this.firePowerPlayer -= amount;
    }

    public void decreasePassengersPower(int amount) {
        this.passengersPower -= amount;
    }

    public void decreaseHeaterPower(int amount) {
        this.heaterPowerPlayer -= amount;
    }

    public void decreaseBatteries(int amount) {
        this.numberBatteries -= amount;
    }


    public boolean matchesConnectorHor(Tile tileleft, Tile tileright) {
        if (tileleft.getConnectors()[2] == tileright.getConnectors()[0]) {
            return true;
        } else {
            return false;
        }
    }

    public boolean matchesConnectorVer(Tile tiledown, Tile tileup) {
        if (tiledown.getConnectors()[1] == tileup.getConnectors()[3]) {
            return true;
        } else {
            return false;
        }
    }
    //FIREPOWER:
    //Check the fire power of the playerBoard
    //attenzione a quando bisogna vedere se uno vuole usare le batterie o no e bisogna fare scegliere ai giocatori in ordine
    public double checkFirePower(){
        double power = 0;
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j ++) {
                  if( this.matrixBoard[i][j] instanceof Drill) {
                      power = power + ((Drill) matrixBoard[i][j]).getPower();
                  }
            }
        }
        return power;
    }
    public void setFirePower(){
        this.firePowerPlayer = checkFirePower();
    }

    //HEATER:
    public int checkHeaterPower(){
        int power = 0;
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j ++) {
                if( this.matrixBoard[i][j] instanceof Heater) {
                    power = power + ((Heater) matrixBoard[i][j]).getValue();
                }
            }
        }
        return power;
    }
    public void setHeaterPower(){
        this.heaterPowerPlayer = checkHeaterPower();
    }

    //PASSENGER:
    public int checkPassengersPower(){
        int power = 0;
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j ++) {
                if(this.matrixBoard[i][j] instanceof HousingUnit) {
                    power = power + ((HousingUnit) matrixBoard[i][j]).countPassengers();
                } else if (this.matrixBoard[i][j] instanceof CentralHousingUnit) {
                    power = power + ((CentralHousingUnit) matrixBoard[i][j]).countPassengers();
                }
            }
        }
        return power;
    }
    //At the start of the game (to set the attribute)
    public void setPassengerPower(){
        this.passengersPower = checkPassengersPower();
    }
    //During the game to modify the attribute and the tiles
    public void modifyPassengerPower(int passengerLoss){
        this.passengersPower = this.passengersPower - passengerLoss;
        while(passengerLoss > 0){
            int row = askrow(); // chiedo al player da che housing unit vuole togliere un passenger
            int col = askcol();
            if(((HousingUnit) matrixBoard[row][col]).removeAstronauts()) {//I'm removing 1 astronaut form the selected housing unit
                passengerLoss--;
            }
        }
    }
    public int askrow(){
        int row = 0;
        return  row;
    } //controller
    public int askcol(){
        int col = 0;
        return  col;
    } //controller

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
    public void removeStorage(int n){
        int row;
        int col;
        while(n>0){
            for(int j=4; j>0;j--){
                for(row=0; row<numRows;row++){
                    for(col=0; col<numColumns; col++){
                        Tile tile = matrixBoard[row][col];
                        if(tile instanceof Storage){
                            for(int i=0; i<n; i++){
                                if(((Storage)tile).removeCargo(j)){
                                    n--;
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public void shoot (Map<Integer, Integer> shootsMap){
        //implementare
    }
    public void meteorShoot (int size, int direction, int dice){
        //implementare
    }
    public Tile[] getStockInitialArray() {
        return stockInitialArray;
    }
    public Tile[][] getMatrixBoard(){
        return matrixBoard;
    }
}
