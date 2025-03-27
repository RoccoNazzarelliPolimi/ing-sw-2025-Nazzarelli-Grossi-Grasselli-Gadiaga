public class Drill extends Tile {
    private int[] directions;//array di 4 elementi che ha la punta dove c'è 1
    private int drillType; // 1 o 2
    private double value; //0,5 o 1 o 2

    // Costruttore
    public Drill(int[] connectors, int row, int column, PlayerBoard playerBoard, int drillType, int value, int[] directions) {
        super(connectors, row, column, playerBoard);
        this.directions = directions;
        this.drillType = drillType;
        this.value = value;
    }

    public void setValue(){
        if (directions[1] == 1) { // if the drill points up
            this.value = drillType;
        } else if (directions[0] == 1 || directions[2] == 1) { // If the drill is orizontal
            this.value = drillType / 2.0;
        }
    }

    //returns the power of the Drill
    public double getPower(){
        return value;
    }

    public int[] getDirections(){
        return this.directions;
    }
    public int[] getSides(){
        return this.connectors;
    }



    public void accept(TileVisitor visitor) {
        visitor.visit(this);
    }

}
