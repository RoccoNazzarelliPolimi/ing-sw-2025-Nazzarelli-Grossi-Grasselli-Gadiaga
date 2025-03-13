public class Storage {

    private int capacity;
    //array di 4 elementi che controlla per ogni lato il tipo di connettore
    // es.[1 3 0 0] connettore da 1 a sx e da 3 sopra
    private int[] sides;
    private int numCargo;
    private boolean canRed;
    // Checks the value of each unit of cargo
    private int[] cargoValues;

    public Storage(int capacity, int[] sides) {
        this.capacity = capacity;
        this.sides = sides;
    }

    public String checkTypeTile() {
        return "Storage";
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
        if
        (canRed){
            return true;

        } else {
            return false;
        }

    }
    //checks the sum of the values of each cargo

    //returns an int that sums the value of the cargos inside the storage unit
    public int checkTotalValue() {
        int total = 0;
        for (int i=0; i< numCargo; i++) {
            total += cargoValues[i]; //sommo i valori dei singoli cargo
        }
      return total;
    }

    //method for adding a cargo da implementare bene

    public void addCargo(int amount){
        if (amount > 0 && numCargo + amount <= capacity) {
            numCargo += amount;

        }

    }

    public boolean checkFull(){
        return numCargo >= capacity;
    }

}
