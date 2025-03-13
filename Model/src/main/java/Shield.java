public class Shield extends Tile {
    private int[] sides;
    private int[] defence; // 1 = scudo attivo su quel lato, 0 = nessuno scudo

    // Costruttore
    public Shield(int[] sides, int[] defence) {
        this.sides = new int[3];;
        this.defence = new int[3];;
    }

    // Metodo per ottenere i lati protetti dallo scudo
    public int[] getDefence() {
        return defence;
    }

    // Restituisce il tipo della Tile
    public String checkTypeTile() {
        return "Shield";
    }

    public int[] getSides() {
        return sides;
    }
}

