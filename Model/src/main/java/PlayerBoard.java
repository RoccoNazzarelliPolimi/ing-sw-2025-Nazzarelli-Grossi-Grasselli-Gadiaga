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

        //Set the row and column of the tile as the ones in input
        tile.setRow(row);
        tile.setCol(col);

        Set<String> posVietate = new HashSet<>(List.of(
                "4,3", "4,4", "4,5", "4,6", "4,8", "4,9", "4,10", "4,11",
                "5,3", "5,4", "5,5", "5,9", "5,10", "5,11",
                "6,3", "6,4", "6,10", "6,11",
                "7,3", "7,4", "7,10", "7,11",
                "8,3", "8,11",
                "9,3", "9,11", "9,7"
        ));

        String pos = row + "," + col;

        if (row >= 0 && row < numRows && col >= 0 && col < numColumns && matrixBoard[row][col] == null) {
            if (row >= 4 && row <= 9 && col >= 3 && col <= 11) {
                if (!posVietate.contains(pos))
                {matrixBoard[row][col] = tile;
                    numberTile++;
                    System.out.println("Tile " + tile + " was set in position: " + row + " and " + col);
                }
                else {
                    System.out.println("You are not allowed to insert a cell in that position 2 if!!!!");
                }
            } else {
                System.out.println("You are not allowed to insert a cell in that position 1 if!!!!");
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
        return true;
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
        int connection=1;
        boolean[][] visited = new boolean[numRows][numColumns]; // Matrice per tracciare le HousingUnit già visitate
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (!visited[i][j] && (matrixBoard[i][j] instanceof HousingUnit || matrixBoard[i][j] instanceof CentralHousingUnit)) {
                    visited[i][j] = true; // Segna come visitata
                    // Sx
                    if (matrixBoard[i][j - 1] != null) { //controllo se c'è una tile
                        Tile nextTile = matrixBoard[i][j - 1];
                        if (!visited[i][j-1] && (nextTile instanceof HousingUnit || nextTile instanceof CentralHousingUnit)) {
                            connection++;
                        }
                    }
                    // Dx
                    if (matrixBoard[i][j + 1] != null) {
                        Tile nextTile = matrixBoard[i][j + 1];
                        if (!visited[i][j + 1] && (nextTile instanceof HousingUnit || nextTile instanceof CentralHousingUnit)) {
                            connection++;
                        }
                    }
                    // Up
                    if (matrixBoard[i - 1][j] != null) {
                        Tile nextTile = matrixBoard[i - 1][j];
                        if (!visited[i - 1][j] && (nextTile instanceof HousingUnit || nextTile instanceof CentralHousingUnit)) {
                            connection++;
                        }
                    }
                    // Down
                    if (matrixBoard[i + 1][j] != null) {
                        Tile nextTile = matrixBoard[i + 1][j];
                        if (!visited[i + 1][j] && (nextTile instanceof HousingUnit || nextTile instanceof CentralHousingUnit)) {
                            connection++;
                        }
                    }


                }
            }
        }
        if (connection==1){ //because I initialized it to 1
            return 0;
        }
        return connection;
    }

    public void checkStorage(List<Integer> load){
        int size=load.size();
        int row;
        int col;
        int k;

        while (!load.isEmpty()) {
            boolean added = false;
            int cargo = load.get(0); // sempre il primo

            for (row = 0; row < numRows; row++) {
                for (col = 0; col < numColumns; col++) {
                    Tile tile = matrixBoard[row][col];

                    if (tile instanceof Storage) {
                        Storage storage = (Storage) tile;

                        // Se c'è spazio e si può aggiungere
                        if (storage.checkCapacity()> 0){
                            System.out.println("capacity: " + storage.checkCapacity());
                            if(storage.addCargo(cargo)) {
                                System.out.println("added in " + row + " " + col);
                                load.remove(0);
                                added = true;
                                break;
                            }
                        }

                        // Altrimenti: valutiamo se sostituire un cargo meno prezioso
                        List<Integer> values = storage.getCargoValues();
                        if (!values.isEmpty()) {
                            Collections.sort(values);
                            if (values.get(0) < cargo) {
                                storage.removeCargo(values.get(0));
                                if(storage.addCargo(cargo)) {
                                    System.out.println("replaced in " + row + " " + col);
                                    load.remove(0);
                                    added = true;
                                    break;
                                }

                            }
                        }
                    }
                }
                if (added) break; // esci dai due for se è stato inserito
            }

            if (!added) {
                System.out.println("Cargo " + cargo + " scartato.");
                load.remove(0); // non è stato inserito, rimuovilo lo stesso
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
    private boolean hasShield(int direction) {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                Tile tile = matrixBoard[i][j];
                if (tile instanceof Shield) {
                    int[] defence = ((Shield) tile).getDefence();
                    if (defence[direction]==1) {
                        return true; //shield found
                    }
                }
            }
        }
        return false;
    }

    public void shoot (List<Pair> shootsMap){
        Random random = new Random(); //dadi

        for (Pair pair : shootsMap) {
            int size = pair.first;         // 1 = small, 2 = big
            int direction = pair.second;  // 1 = sx, 2 = up, 3 = dx, 4 = down
            int dice = random.nextInt(12) + 1;     // Valore da 1 a 12
            System.out.println("Dice: " + dice + ", Pair: "+ size + ","+ direction);

            int row = -1;
            int col = -1;

            if (direction == 1) { // sinistra
                if (dice>3 && dice<10){ // se no so già che non colpisce niente
                    row = dice;
                    for (col = 0; col < numColumns; col++) {
                        if (matrixBoard[row][col] != null) {
                            if (size == 1 && hasShield(0)) return; // protetta da sinistra
                            System.out.println("Shild covered from sx");
                            deleteTile(matrixBoard[row][col], row, col);
                        }
                    }
                }
            }else if (direction == 2) { // su
                if (dice>3 && dice<11){
                    col = dice;
                    for (row = 0; row < numRows; row++) {
                        if (matrixBoard[row][col] != null) {
                            if (size == 1 && hasShield(1)) return; // protetta da sopra
                            System.out.println("Shild covered from up");
                            deleteTile(matrixBoard[row][col], row, col);
                        }
                    }
                }
            } else if (direction == 3) { // destra
                if (dice>3 && dice<10){
                    row = dice;
                    for (col = numColumns - 1; col >= 0; col--) {
                        if (matrixBoard[row][col] != null) {
                            if (size == 1 && hasShield(2)) return; // protetta da destra
                            System.out.println("Shild covered from dx");
                            deleteTile(matrixBoard[row][col], row, col);
                        }
                    }
                }
            } else if (direction == 4) { // giù
                if (dice>3 && dice<11){
                    col = dice;
                    for (row = numRows - 1; row >= 0; row--) {
                        if (matrixBoard[row][col] != null) {
                            if (size == 1 && hasShield(3)) return; // protetta da sotto
                            System.out.println("Shild covered from down");
                            deleteTile(matrixBoard[row][col], row, col);
                        }
                    }
                }
            }
            System.out.println("No tiles shooted");
        }

        checkBoardConnections(); // Ricontrolla la board dopo tutti i colpi
    }

    public void meteorShoot (int size, int direction, int dice){
        int row = -1;
        int col = -1;

        if (direction == 1) { // sinistra
            row = dice;
            for (col = 0; col < numColumns; col++) {
                Tile tile = matrixBoard[row][col];
                if (tile != null) {
                    if (size == 1) {
                        if (tile.getConnectors()[0] == 0) return; // rimbalza
                        if (hasShield(0)) return; // scudo
                    } else if (size == 2 && tile instanceof Drill) {
                        if (((Drill) tile).getDirections()[0] == 1) return; // gli sparo
                    }
                    deleteTile(tile, row, col);
                    break;
                }
            }
        }else if (direction == 2) { // su
            col = dice;
            for (row = 0; row < numRows; row++) {
                Tile tile = matrixBoard[row][col];
                if (tile != null) {
                    System.out.println("Connector in up: "+ tile.getConnectors()[1]);
                    if (size == 1) {
                        if (tile.getConnectors()[1] == 0){
                            System.out.println("bounces off");
                            return;
                        }
                        if (hasShield(1)) {
                            System.out.println("there is a shield");
                            return;
                        }
                    } else if (size == 2 && tile instanceof Drill) {
                        if (((Drill) tile).getDirections()[1] == 1){
                            System.out.println("shooted down");
                            return;
                        }
                    }
                    deleteTile(tile, row, col);
                    System.out.println("tile was hit");
                    break;
                }
            }
        } else if (direction == 3) { // destra
            row = dice;
            for (col = numColumns - 1; col >= 0; col--) {
                Tile tile = matrixBoard[row][col];
                if (tile != null) {
                    if (size == 1) {
                        if (tile.getConnectors()[2] == 0) return;
                        if (hasShield(2)) return;
                    } else if (size == 2 && tile instanceof Drill) {
                        if (((Drill) tile).getDirections()[2] == 1) return;
                    }
                    deleteTile(tile, row, col);
                    break;
                }
            }
        } else if (direction == 4) { // giù
            col = dice;
            for (row = numRows - 1; row >= 0; row--) {
                Tile tile = matrixBoard[row][col];
                if (tile != null) {
                    if (size == 1) {
                        if (tile.getConnectors()[3] == 0) return;
                        if (hasShield(3)) return;
                    } else if (size == 2 && tile instanceof Drill) {
                        if (((Drill) tile).getDirections()[3] == 1) return;
                    }
                    deleteTile(tile, row, col);
                    break;
                }
            }
        }
        checkBoardConnections(); // Ricontrolla
    }

    public Tile[] getStockInitialArray() {
        return stockInitialArray;
    }
    public Tile[][] getMatrixBoard(){
        return matrixBoard;
    }
}
