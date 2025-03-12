public class PowerCenter {

    private int[] sides;
    //it says how many batteries can be allocated into the tile
    private int capacityBattery;
    //how many batteries are available to use
    private int availableBattery;

    //costruttore
    public PowerCenter(int[] sides, int capacityBattery, int availableBattery) {
        this.sides = sides;
        this.capacityBattery = capacityBattery;
        this.availableBattery = availableBattery;
    }

    //method for adding batteries
    public void addBattery(int amount){
        if (amount > 0 && availableBattery + amount <= capacityBattery ){
            availableBattery += amount;
        }
    }

    //method for removing batteries
    public void removeBattery(int amount){
        if (amount > 0 && availableBattery + amount <= capacityBattery ){
            availableBattery -= amount;
        }
    }

    public String CheckTypeTile() {
        return "PowerCenter";
    }




}
