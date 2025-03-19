public class Heater extends Tile {
    private int[] sides;
    private int heaterType; //1 se singolo, 2 se doppio (e a batteria)
    private int value; // 1 se singolo, 2 se doppio ( se si usa la batteria)

    // Costruttore
    public Heater(int[] connectors, int row, int column, PlayerBoard playerBoard, int heaterType, int value) {
        super(connectors, row, column, playerBoard);
        this.heaterType = heaterType;
        this.value = value;
    }

    //sempre 1 se singolo, 2 solo se doppio e si usa la batteria
    public int getValue() {
        if (heaterType == 1) {
            return value;
        }
        if (heaterType == 2) {
            return value; //Bisogna chiedere se si vuole usare la batteria
        }
        return 0;
    }

    public int getHeaterType() {
        return this.heaterType;
    }

    public int[] getSides() {
        return this.connectors;
    }

}

