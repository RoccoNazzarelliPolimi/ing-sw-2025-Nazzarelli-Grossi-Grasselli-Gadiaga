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

    public void checkBoard() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrixBoard[i][j] != null) {
                    Tile currentTile = matrixBoard[i][j];

                    // Controlla connettori a sinistra
                    if (j > 0 && matrixBoard[i][j - 1] != null) {
                        if (!currentTile.matchesConnector(matrixBoard[i][j - 1], "LEFT")) {
                            System.out.println("Errore di connessione a sinistra per la tessera in posizione (" + i + ", " + j + ")");
                        }
                    }

                    // Controlla connettori a destra
                    if (j < numColumns - 1 && matrixBoard[i][j + 1] != null) {
                        if (!currentTile.matchesConnector(matrixBoard[i][j + 1], "RIGHT")) {
                            System.out.println("Errore di connessione a destra per la tessera in posizione (" + i + ", " + j + ")");
                        }
                    }

                    // Controlla connettori in alto
                    if (i > 0 && matrixBoard[i - 1][j] != null) {
                        if (!currentTile.matchesConnector(matrixBoard[i - 1][j], "UP")) {
                            System.out.println("Errore di connessione in alto per la tessera in posizione (" + i + ", " + j + ")");
                        }
                    }

                    // Controlla connettori in basso
                    if (i < numRows - 1 && matrixBoard[i + 1][j] != null) {
                        if (!currentTile.matchesConnector(matrixBoard[i + 1][j], "DOWN")) {
                            System.out.println("Errore di connessione in basso per la tessera in posizione (" + i + ", " + j + ")");
                        }
                    }
                }
            }
        }
    }


    public Connector getRightConnector() {
        return this.connectors[1]; // Supponendo che 1 sia la posizione del connettore destro
    }

    public Connector getLeftConnector() {
        return this.connectors[3]; // Supponendo che 3 sia la posizione del connettore sinistro
    }

    public Connector getTopConnector() {
        return this.connectors[0]; // Supponendo che 0 sia la posizione del connettore superiore
    }

    public Connector getBottomConnector() {
        return this.connectors[2]; // Supponendo che 2 sia la posizione del connettore inferiore
    }

    public boolean matchesConnector(Tile other, String direction) {
        if (other == null) {
            return false;
        }

        switch (direction) {
            case "LEFT":
                return this.getRightConnector() == other.getLeftConnector();
            case "RIGHT":
                return this.getLeftConnector() == other.getRightConnector();
            case "UP":
                return this.getBottomConnector() == other.getTopConnector();
            case "DOWN":
                return this.getTopConnector() == other.getBottomConnector();
            default:
                return false;
        }
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

    public void checkStorage() {

        int row=0;
        int col=0;

        for ( row= 0; row < numRows; row++) {
            for (col =  0; col < numColumns; col++) {

                if (matrixBoard[row][col] instanceof Storage) {




            }




            }


        }


    }




}
