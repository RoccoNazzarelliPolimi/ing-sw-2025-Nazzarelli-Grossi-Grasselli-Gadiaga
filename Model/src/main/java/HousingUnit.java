import java.util.Optional;

public class HousingUnit extends Tile {
    private int numAstronauts;
    private boolean alienAddOn;
    private Alien alien; // L'alieno associato (se presente)
    private int numAlien;

    // Costruttore
    public HousingUnit(int[] connectors, int row, int column, PlayerBoard playerBoard,  Alien alien, int numAstronauts, boolean alienAddOn, int numAlien) {
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
        return alienAddOn;
    }

    // Restituisce il colore dell'alieno se presente
    public AlienColor getAlienColor() {
        return (alien != null) ? alien.getColor() : null;
    }

    public AlienColor checkAlienAddOn() {
        return null; //implementare
    }


    // Imposta alienAddOn a true se esiste un Add-On
    public void setAlienAddOn() {
        this.alienAddOn = checkAlienAddOn() != null;
    }

    // Aggiunge astronauti (ad inizio gioco)
    public void addAstronauts() {
        this.numAstronauts = 2;
    }

    // Removes 1 astronaut
    public boolean removeAstronauts(){
        if (numAstronauts>0) {
            numAstronauts -= 1;
            return true;
        } else {
            System.out.println("Not enough astronauts");
            return false;
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

    public int[] getConnectors() {
        return connectors;
    }
}
