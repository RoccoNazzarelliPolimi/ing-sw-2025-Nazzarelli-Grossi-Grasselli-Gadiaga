import java.util.List;
import java.util.Map;

public class Planets extends Card{
    private Map<Integer, List<Integer>> planetCargo; // Mappa: numero del pianeta → lista dei cargo

    //costruttore
    public Planets(Deck deck, int credit, int steps){
        super(deck, credit, steps);
        Map<Integer, List<String>> planetCargo;
    }

    public void planets (Gameboard gameBoard){
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket: rocketsArray) {
            if (ask()) {
                int planet= askWhich();
                rocket.getRocketPlayer().getMyBoard().checkStorage(planetCargo.get(planet-1)); //planet in prima posizione sarà 1 quindi metto "-1" per estrarlo
                planetCargo.remove(planet-1);
                gameBoard.movePlayer(rocket, steps);
                if (planetCargo.isEmpty()) {
                    break; // Esce dal ciclo
                }
            }
        }
    }
    public boolean ask(){ //giusto per non fare errore
        return true;
    }
    public int askWhich(){ //giusto per non fare errore
        return 1;
    }
}
