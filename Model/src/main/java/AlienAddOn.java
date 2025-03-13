import java.util.List;

public class AlienAddOn extends Tile {
    private int[] sides;
    private AlienColor color; //PURPLE O BROWN

    // Costruttore
    public AlienAddOn(int[] sides, AlienColor color) {
        this.sides = new int[3];;
        this.color = color;
    }

    // Metodo per ottenere il tipo di Tile
    public String CheckTypeTile() {
        return "Alien Add-On";
    }

    // Metodo per controllare il colore dell'alieno
    public boolean checkColor() {
        int[] housingUnitCoords = checkNextHousingUnit(); // Troviamo la HousingUnit vicina

        if (housingUnitCoords == null) {
            return false; // Nessuna HousingUnit trovata
        }

        PlayerBoard board = getCell().getPlayerBoard(); // Otteniamo la board dalla cella

        if (board == null) {
            return false; // Se non esiste una board, non possiamo cercare celle
        }

        Cell housingCell = board.getCellAt(housingUnitCoords[0], housingUnitCoords[1]); // Otteniamo la cella della HousingUnit

        if (housingCell != null && housingCell.checkTileOptional().orElse(null) != null) {
            Tile housingTile = housingCell.checkTileOptional().orElse(null);
            HousingUnit housingUnit = (HousingUnit) housingTile;

            return (housingUnit.hasAlien() && this.color == housingUnit.getAlienColor());
        }

        return false;
    }



    // Metodo per verificare se c'è una Housing Unit nelle vicinanze
    public int[] checkNextHousingUnit() {
        if (getCell() == null) {
            return null; // L'Add-On non è piazzato su una cella
        }

        PlayerBoard board = getCell().getPlayerBoard(); // Otteniamo la PlayerBoard dalla cella

        if (board == null) {
            return null; // Se la cella non ha una board associata, ritorniamo null
        }

        int[] coordinates = getCell().getCoordinates();
        int row = coordinates[0];
        int col = coordinates[1];

        int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} }; // Destra, Sinistra, Sopra, Sotto

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            Cell adjacentCell = board.getCellAt(newRow, newCol); // Ora chiamiamo il metodo sulla board

            // Verifica che la cella sia nella lista e abbia una Tile
            if (adjacentCell != null && board.getAllCells().contains(adjacentCell) && adjacentCell.checkTileOptional().orElse(null) != null) {
                Tile adjacentTile = adjacentCell.checkTileOptional().orElse(null);

                if (adjacentTile instanceof HousingUnit) {
                    return new int[]{newRow, newCol}; // Restituisce le coordinate della HousingUnit
                }
            }
        }

        return null; // Nessuna HousingUnit trovata
    }

    public AlienColor getColor() {
        return color;
    }

    public int[] getSides() {
        return sides;
    }
}
