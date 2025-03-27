public class CentralHousingUnit extends Tile{
    private int numAstronauts;

    //costruttore
    public CentralHousingUnit(int[] connectors, int row, int column, PlayerBoard playerBoard, int numAstronauts) {
        super(connectors, row, column, playerBoard);
        this.numAstronauts = 2;
    }


    public void accept(TileVisitor visitor) {
        visitor.visit(this);
    }

    //metodo per contare gli astronauti a bordo
    public int countPassengers() {
        return numAstronauts;
    }

    //metodo per aggiungere astronauti
    public void setAstronauts(int n){
        numAstronauts+= 2;
    }

    //metodo per togliere astronauti
    public void removeAstronauts(int n){
        if (n>0 && n<=numAstronauts) {
            numAstronauts -= n;
        } else {
            System.out.println("number illegal");
        }
    }
    public int[] getSides() {
        return this.connectors;
    }
}
