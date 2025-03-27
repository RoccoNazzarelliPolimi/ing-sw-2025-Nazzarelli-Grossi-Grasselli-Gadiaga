import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// Classe Combat Zone
public class CombatZone extends  Card{
    private List<Action> actions;

    public CombatZone(Deck deck, int credit, int steps,int cardLevel, Gameboard gameBoard) {
        super(deck, credit, steps, cardLevel);
        actions = new ArrayList<>();
    }

    public void combatZone (Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        Rocket loser = null;
        for (Action action : actions) {
            //finding the loser based on the condition
            String targetCondition = action.getTargetCondition(); //"passenger", "heater", "drill"
            if (targetCondition == "drill") {
                double min = 0;
                for (Rocket rocket : rocketsArray) {
                    double currentFirePower = rocket.getRocketPlayer().getMyBoard().checkFirePower();
                    if (currentFirePower < min) { //if two players have the same power only the first one loses
                        min = currentFirePower;
                        loser = rocket;
                    }
                }
            }
            else if (targetCondition == "heater"){
                double min = 0;
                for (Rocket rocket : rocketsArray){
                    double currentHeaterPower = rocket.getRocketPlayer().getMyBoard().checkHeaterPower();
                    if(currentHeaterPower<min){
                        min = currentHeaterPower;
                        loser = rocket;
                    }
                }
            }
            else if (targetCondition == "passenger"){
                double min = 0;
                for (Rocket rocket : rocketsArray){
                    double currentPassengerPower = rocket.getRocketPlayer().getMyBoard().checkPassengersPower();
                    if(currentPassengerPower<min){
                        min = currentPassengerPower;
                        loser = rocket;
                    }
                }
            }
            //loser found
            //penalty
            String penaltyType = action.getPenaltyType();// "days", "passenger", "cargo"
            int penaltyValue = action.getPenaltyValue();
            Map<Integer, Integer> shootsMap= action.getShootsMap();//size(1 small, 2 big), direction (1sx, 2up, 3dx, 4down)
            if (penaltyType != null && shootsMap == null) { //action 1 or 2
                if (penaltyType == "days"){
                    gameBoard.movePlayer(loser, penaltyValue);
                }
                else if (penaltyType == "passenger"){
                    loser.getRocketPlayer().getMyBoard().modifyPassengerPower(penaltyValue);
                }
                else if (penaltyType == "cargo"){
                    loser.getRocketPlayer().getMyBoard().removeStorage(penaltyValue);
                }
            }
            else if (penaltyType == null && shootsMap != null) { //action 3
                loser.getRocketPlayer().getMyBoard().shoot(shootsMap);
            }
        }

    }










}
