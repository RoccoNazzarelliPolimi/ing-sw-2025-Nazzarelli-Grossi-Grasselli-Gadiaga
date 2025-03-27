import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeteorSwarm extends Card {
    private List<Pair> meteoriteMap; // size(1 small, 2 big), direction (1sx, 2up, 3dx, 4down)

    // Costruttore vuoto (aggiungilo solo se necessario)
    public MeteorSwarm(Deck deck, int credit, int steps, int cardLevel, Map<Integer, Integer> meteoriteMap ) {
        super(deck, credit, steps);
        meteoriteMap = new HashMap<Integer, Integer>();
    }

    //
    public void meteorSwarm (Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Pair pair : meteoriteMap) {
            Integer size = pair.first;
            Integer direction = pair.second;
            //roll dice

            int dice = 6; //esempio
            for (Rocket rocket : rocketsArray) {
                rocket.getRocketPlayer().getMyBoard().meteorShoot(size, direction, dice);
            }



        }

    }




}
