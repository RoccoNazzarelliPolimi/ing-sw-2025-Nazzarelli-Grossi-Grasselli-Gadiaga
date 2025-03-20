import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

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

    //checks if this HousingUnit has an AlienAddOn near , if it does it returns the color
    public List<AlienColor> checkAlienAddOn() {
        List<AlienColor> color= new ArrayList<>();; //creo una lista perchè magari c'è più di un AddOn attaccato
        Tile[][] matrix = getPlayerBoard().getMatrixBoard(); //this player PlayerBoard
        int row = getRow(); //row and col of this housing unit
        int col = getCol();

        //Sx
        if (matrix[row][col - 1] != null) { //controllo se c'è una tile
            Tile nextTile= matrix[row][col - 1];
            if (nextTile instanceof AlienAddOn) { //se è un add on aggiungo il colore alla lista
                color.add(((AlienAddOn) nextTile).getColor());
            }
        }
        //Dx
        if (matrix[row][col + 1] != null) {
            Tile nextTile= matrix[row][col + 1];
            if (nextTile instanceof AlienAddOn) { //se è un add on aggiungo il colore alla lista
                color.add(((AlienAddOn) nextTile).getColor());
            }
        }
        //Up
        if (matrix[row - 1][col] != null) {
            Tile nextTile= matrix[row - 1][col];
            if (nextTile instanceof AlienAddOn) { //se è un add on aggiungo il colore alla lista
                color.add(((AlienAddOn) nextTile).getColor());
            }
        }
        //Down
        if (matrix[row + 1][col] != null) {
            Tile nextTile= matrix[row + 1][col];
            if (nextTile instanceof AlienAddOn) { //se è un add on aggiungo il colore alla lista
                color.add(((AlienAddOn) nextTile).getColor());
            }
        }
        return color;
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
        List<AlienColor> color = checkAlienAddOn(); // Trova il colore dell'Add-On adiacente
        if (color.size() == 1) { //se esiste e se è solo uno
            AlienColor col= color.get(0);
            this.numAlien = 1;
            this.alien = new Alien(this, col); //Crea un nuovo alieno
        }else if (color.size() > 1) { //se esiste ed è maggiore di uno
            AlienColor col= askColor(); //sceglie quale mettere
            this.numAlien = 1;
            this.alien = new Alien(this, col);
        }
        else {
            System.out.println("No alien add on");
        }
    }
    public AlienColor askColor() { //finto
        return null;
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


    public void accept(TileVisitor visitor) {
        visitor.visit(this);
    }

    public int[] getConnectors() {
        return connectors;
    }
}
