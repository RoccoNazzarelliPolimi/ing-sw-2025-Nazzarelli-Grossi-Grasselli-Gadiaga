public class CentralHousingUnit {
    private int numAstronauts;
    private int[] sides;

    //costruttore

    public CentralHousingUnit(int numAstronauts, int[] sides) {
        this.numAstronauts = numAstronauts;
        this.sides = sides;

    }

    //metodo per contare gli astronauti a bordo
    public int countPassengers() {
        return numAstronauts;
    }

    //metodo per controllare il tipo di connettore
    public String CheckTypeTile() {
        return "CentralHousingUnit";
    }

    //metodo per aggiungere astronauti
    public void addAstronauts(int n){
        if (n > 0 && n <= numAstronauts) {
            numAstronauts+= n;

        } else {
            System.out.println("Astronauts can't be empty or number illegal");
        }

    }

    //metodo per togliere astronauti
    public void removeAstronauts(int n){
        if (n>0 && n<=numAstronauts) {
            numAstronauts -= n;
        } else {
            System.out.println("number illegal");
        }
    }


}
