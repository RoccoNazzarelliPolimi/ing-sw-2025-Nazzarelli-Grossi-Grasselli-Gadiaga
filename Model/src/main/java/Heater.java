public class Heater extends Tile {
    private int[] sides;
    private int heaterType; //1 se singolo, 2 se doppio (e a batteria)
    private double value; // 1 se singolo, 2 se doppio ( se si usa la batteria)

    // Costruttore
    public Heater(int[] sides, int heaterType, double value) {
        this.sides = sides;
        this.heaterType = heaterType;
        this.value = value;
    }

    // Metodo per ottenere il tipo di Tile
    public String checkTypeTile() {
        return "Heater";
    }

    // Getter per i lati
    public int[] getSides() {
        return sides;
    }

    public int getHeaterType() {
        return heaterType;
    }

    public double getValue() {
        return value;
    }
}

