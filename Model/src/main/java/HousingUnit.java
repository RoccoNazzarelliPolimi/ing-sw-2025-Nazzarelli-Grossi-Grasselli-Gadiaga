import java.util.Optional;

public class HousingUnit extends Tile {
    private int numAstronauts;
    private int[] sides;
    private boolean alienAddOn;
    private Alien alien;        // L'alieno associato (se presente)
    private int numAlien;

    // Costruttore
    public HousingUnit(int[] sides) {
        this.sides = sides;
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
        return numAlien > 0 && alien != null;
    }

    // Restituisce il colore dell'alieno se presente
    public AlienColor getAlienColor() {
        return (alien != null) ? alien.getColor() : null;
    }

    // Controlla se c'è un Alien Add-On adiacente
    public AlienColor checkAlienAddOn() {
        if (getCell() == null) return null; // Se la HousingUnit non è piazzata

        PlayerBoard board = getCell().getPlayerBoard();
        if (board == null) return null;

        int[] coordinates = getCell().getCoordinates();
        int row = coordinates[0];
        int col = coordinates[1];

        int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} }; // Destra, Sinistra, Sopra, Sotto

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            Cell adjacentCell = board.getCellAt(newRow, newCol);

            if (adjacentCell != null) {
                Optional<Tile> optionalTile = adjacentCell.checkTileOptional();
                if (optionalTile.isPresent() && optionalTile.get() instanceof AlienAddOn) {
                    AlienAddOn addOn = (AlienAddOn) optionalTile.get();
                    return addOn.getColor();
                }
            }
        }
        return null;
    }

    // Imposta alienAddOn a true se esiste un Add-On
    public void setAlienAddOn() {
        this.alienAddOn = checkAlienAddOn() != null;
    }

    // Aggiunge astronauti (ad inizio gioco)
    public void addAstronauts() {
        this.numAstronauts = 2;
    }
    // Rimuove 1 astronauta
    public void removeAstronauts() {
        this.numAstronauts = this.numAstronauts -1;
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
        this.numAlien = 0;
        this.alien = null;
    }

    public String checkTypeTile() {
        return "Housing Unit";
    }

    public int[] getSides() {
        return sides;
    }
}
