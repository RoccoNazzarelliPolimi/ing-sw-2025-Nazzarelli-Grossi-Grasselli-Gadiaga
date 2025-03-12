public class HousingUnit extends Tile {
    private int numAstronauts;
    private int[] sides;
    private boolean alienAddOn;
    public boolean aliens; // Se true, significa che ci sono alieni

    // Costruttore
    public HousingUnit(int[] sides) {
        this.sides = sides;
        this.numAstronauts = 0;
        this.alienAddOn = false;
        this.aliens = false;
    }

    // Restituisce il colore dell'alieno se presente
    public String getAlienColor() {
        if (aliens && alienAddOn) {
            return "Alien Color"; // Da sostituire con il vero colore se memorizzato altrove
        }
        return null; // Nessun alieno presente
    }
    //devo finire
}
