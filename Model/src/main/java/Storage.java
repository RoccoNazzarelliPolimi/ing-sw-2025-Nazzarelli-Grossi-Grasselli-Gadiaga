import java.util.ArrayList;
import java.util.List;
public class Storage {
    private int capacity;
    private int[] sides;
    private int numCargo;
    private boolean canRed;
    private List<Integer> cargoValues; //4 rosso, 3 giallo, 2 verde, 1 blu

    public Storage(int capacity, int[] sides) {
        this.capacity = capacity;
        this.sides =  new int[3];
        this.numCargo = 0;
        this.canRed = canRed;
        this.cargoValues = new ArrayList<>(); //max three cargo
    }

    //method that checks the capacity of the storage unit left
    public int checkCapacity() {
        return capacity - numCargo;
    }

    //method for counting the number of cargo used
    public int countCargo() {
        return numCargo;
    }

    //boolean method to check if the cargo can contain red cargo
    public boolean checkRed() {
        return canRed;
    }

    //returns an int that sums the value of the cargos inside the storage unit
    public int checkTotalValue() {
        int total = 0;
        for (int value : cargoValues) { // Itera direttamente sugli elementi della lista
            total += value;
        }
        return total;
    }

    //adding one cargo
    public void addCargo(int type){
        // Controllo per il cargo rosso
        if (type == 4 && !canRed) {
            System.out.println("Error: This storage can't contain a red cargo.");
            return;
        }

        // Controllo se c'è spazio disponibile
        if (checkCapacity() > 0) {
            cargoValues.add(type);
            numCargo++;
        } else {
            System.out.println("Error: Not enough space to add cargo.");
        }
    }
    //removes the cargo of that color
    public void removeCargo(int type){
        if (cargoValues.contains(type)) {
            cargoValues.remove((Integer) type); // Rimuove il primo valore uguale a type
            numCargo--;
        } else {
            System.out.println("Error: No " + type + " cargo found.");
        }
    }

    public List<Integer> getCargoValues() {
        return cargoValues;
    }

    public int[] getSides() {
        return sides;
    }
}
