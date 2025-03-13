public class PowerCenter {
    private int[] sides;
    private int capacityBattery; // how many batteries can be allocated into the tile
    private int availableBattery; //how many batteries are available to use

    //costruttore
    public PowerCenter(int[] sides, int capacityBattery, int availableBattery) {
        this.sides = new int[3];
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

    public int[] getSides() {
        return sides;
    }
}
