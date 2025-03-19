public class CentralHousingUnit extends Tile{
    private int numAstronauts;
    private int[] sides;

    //costruttore
    public CentralHousingUnit(int row, int column, PlayerBoard playerBoard) {
        super(row, column, playerBoard);
        this.numAstronauts = 0;
        this.sides = new int[3];
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
        return sides;
    }
}
