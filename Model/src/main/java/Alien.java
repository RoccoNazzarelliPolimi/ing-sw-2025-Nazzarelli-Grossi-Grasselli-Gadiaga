public class Alien {
    private HousingUnit housingUnit; // HousingUnit a cui è associato
    private AlienColor color; // PURPLE O BROWN

    // Costruttore
    public Alien(HousingUnit housingUnit, AlienColor color) {
        this.housingUnit = housingUnit;
        this.color = color;
    }

    // Restituisce il colore dell'alieno
    public AlienColor getColor() {
        return color;
    }

    // Restituisce la HousingUnit a cui è assegnato
    public HousingUnit getHousingUnit() {
        return housingUnit;
    }
}

