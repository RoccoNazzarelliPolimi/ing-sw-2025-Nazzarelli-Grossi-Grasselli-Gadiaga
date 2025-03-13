public class Drill extends Tile {
    private int[] sides;
    private int[] directions;//array di 4 elementi che ha la punta dove c'è 1
    private int drillType; // 1 o 2
    private double value; //0,5 o 1 o 2

    // Costruttore
    public Drill(){
        this.sides = new int[3];
        this.directions = new int[3];
        this.drillType = drillType;
        this.value = value;

    }

    //returns the power of the Drill either 1 or 2
    public int getPower(){
        return drillType;
    }

    public int[] getDirections(){
        return directions;
    }
    public int[] getSides(){
        return sides;
    }

    public String checkTypeTile() {
        return "Drill";
    }

    //Method that returns true or false if the drill type needs a battery
    public boolean checkBatteriesNeeded() {
        if (drillType > 1){

            return true;
        }
        return false;

    }










}
