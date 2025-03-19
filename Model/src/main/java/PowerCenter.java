public class PowerCenter extends Tile{
    private int capacityBattery; // how many batteries can be allocated into the tile
    private int availableBattery; //how many batteries are available to use

    //Costruttore
    public PowerCenter(int[] connectors, int row, int column, PlayerBoard playerBoard, int capacityBattery) {
        super(connectors, row, column, playerBoard);
        this.capacityBattery = capacityBattery;
        this.availableBattery = capacityBattery; //at the beginning the availability is equal to the capacity
    }

    //check the number of batteries available on the tile
    public int checkBattery(){
        return availableBattery;
    }

    //removes n batteries
    public void removeBattery(int n){
        if (n > 0 && availableBattery + n <= capacityBattery ){
            availableBattery -= n;
        } else {
            System.out.println("Invalid number");
        }
    }

    public int

    public int[] getSides() {
        return this.connectors;
    }
}
