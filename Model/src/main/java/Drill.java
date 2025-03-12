public class Drill extends Tile {

    //array di 4 elementi che controlla per ogni lato il tipo di connettore
    // es.[1 3 0 0] connettore da 1 a sx e da 3 sopra
    private int[] sides;

    //array di 4 elementi che ha la punta dove c'è 1
    private int[] directions;
    private int drillType;

    //it's one or two
    private double value;

    //costruttore

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
        if (drillType>1){

            return true;
        }

    }










}
