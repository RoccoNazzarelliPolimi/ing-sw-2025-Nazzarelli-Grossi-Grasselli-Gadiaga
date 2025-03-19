import java.util.Optional;

public class HousingUnit extends Tile {
    private int numAstronauts;
    private boolean alienAddOn;
    private Alien alien; // L'alieno associato (se presente)
    private int numAlien;

    // Costruttore
    public HousingUnit(int[] connectors, int row, int column, PlayerBoard playerBoard) {
        super(connectors,row, column, playerBoard);
        this.numAstronauts = 0;
        this.alienAddOn = false;
        this.alien = null;
        this.numAlien = 0;
    }

    // Conta i passeggeri (astronauti o alieni)
    public int countPassengers() {
        return (numAlien > 0) ? numAlien : numAstronauts;
    }

    public boolean hasAlien() {
        return alien != null;
    }

    // Restituisce il colore dell'alieno se presente
    public AlienColor getAlienColor() {
        return (alien != null) ? alien.getColor() : null;
    }

    public AlienColor checkAlienAddOn() {
        // Controllo: se row o col sono null, la Tile non è ancora stata piazzata
        if (this.row == -1 || this.column == -1) {
            return null; // Tile non piazzata, quindi nessun controllo possibile
        }

        PlayerBoard board = getPlayerBoard(); // Recuperiamo la PlayerBoard dalla Tile
        if (board == null) {
            return null; // Se la Tile non è associata a una PlayerBoard, non può controllare gli adiacenti
        }

        int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} }; // Destra, Sinistra, Sopra, Sotto

        for (int[] dir : directions) {
            int newRow = this.row + dir[0];
            int newCol = this.column + dir[1];

            if (newRow >= 0 && newRow < board.getNumRows() &&
                    newCol >= 0 && newCol < board.getNumColumns() &&
                    newRow != 13 && newCol != 13 &&
                    board.getTileAt(newRow, newCol) != null) { // Controlliamo i limiti della board
                Tile adjacentTile = board.getTileAt(newRow, newCol);

                if (adjacentTile instanceof AlienAddOn) {
                    return ((AlienAddOn) adjacentTile).getColor(); // Restituisce il colore dell'Add-On adiacente
                }
            }
        }

        return null; // Nessun Add-On trovato nelle vicinanze
    }


    // Imposta alienAddOn a true se esiste un Add-On
    public void setAlienAddOn() {
        this.alienAddOn = checkAlienAddOn() != null;
    }

    // Aggiunge astronauti (ad inizio gioco)
    public void addAstronauts() {
        this.numAstronauts = 2;
    }

    // Rimuovere n astronauts
    public void removeAstronauts(int n){
        if (n>0 && n<=numAstronauts) {
            numAstronauts -= n;
        } else {
            System.out.println("number illegal");
        }
    }

    // Aggiunge un alieno se c'è un Add-On
    public void addAlien() {
        AlienColor color = checkAlienAddOn(); // Trova il colore dell'Add-On adiacente

        if (color != null) { // Se esiste un Alien Add-On, aggiunge l'alieno
            this.numAlien = 1;
            this.alien = new Alien(this, color); //Crea un nuovo alieno
        }
    }
    // Rimuove l'alieno
    public void removeAliens() {
        if (this.alien != null) { // Controlla se c'è un alieno prima di rimuoverlo
            this.numAlien = 0;
            this.alien = null;
        } else {
            System.out.println("No alien to remove");
        }
    }

    public int[] getSides() {
        return sides;
    }
}
