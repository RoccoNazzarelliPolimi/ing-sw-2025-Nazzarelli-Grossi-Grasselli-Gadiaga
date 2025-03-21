import java.util.HashMap;
import java.util.Map;

// Classe Combat Zone
public class CombatZone extends  Card{
    private Map<String, Map<Integer, String>> map1;
    private Map<String, Map<Integer, String>> map2;
    private Map<String, Map<Integer, Integer>> map3;

    public CombatZone(Deck deck, int credit, int steps,int cardLevel, Gameboard gameBoard) {
        super(deck, credit, steps, cardLevel);

        map1 = new HashMap<String, Map<Integer, String>>();
        map2 = new HashMap<String, Map<Integer, String>>();
        map3 = new HashMap<String, Map<Integer, Integer> ();

        public void combatZone (Gameboard gameBoard) {
            String type = map1.keySet().iterator().next();

            Rocket rocketsArray[]=gameBoard.getRocketArray();
            if (type == "Drill"){

                double min = 0;
                Rocket player = null;
                for (Rocket rocket : rocketsArray){

                    double currentfirePower = gameBoard.getRocketArray().getRocketPlayer().getMyBoard.checkFirePower();

                    if(currentFirePower<min){
                        min = currentfirePower;
                        player = rocket;
                    }
                }
            }
            else if (type == "Heater"){
            }
            else if (type == "Passenger"){
            }
            for (Rocket rocket : rocketsArray){
            }



        }




    }





}
