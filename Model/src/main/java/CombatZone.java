import java.util.HashMap;
import java.util.Map;

// Classe Combat Zone
public class CombatZone extends  Card{
    private Map<String, Map<Integer, String>> map1;
    private Map<String, Map<Integer, String>> map2;
    private Map<String, Map<Integer, Integer>> map3;

    public CombatZone(Deck deck, int credit, int steps) { //aggiungere le map
        super(deck, credit, steps);
        map1 = new HashMap<String, Map<Integer, String>>();
        map2 = new HashMap<String, Map<Integer, String>>();
        map3 = new HashMap<String, Map<Integer, Integer>>();
    }

    public void combatZone (Gameboard gameBoard) {
        String type = map1.keySet().iterator().next();
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        if (type == "Drill"){
            double min = 0;
            Rocket loser = null;
            for (Rocket rocket : rocketsArray){
                double currentFirePower = rocket.getRocketPlayer().getMyBoard().checkFirePower();
                if(currentFirePower<min){
                    min = currentFirePower;
                    loser = rocket;
                }
            }
        }
        else if (type == "Heater"){
        }
        else if (type == "Passenger"){
        }
    }

}
