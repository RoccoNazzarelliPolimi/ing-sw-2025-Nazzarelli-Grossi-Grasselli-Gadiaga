import java.util.ArrayList;
import java.util.List;

public class Smugglers extends Enemies{
    private List<Integer> rewardLoad;
    private int loadLoss;

    //costruttore
    public Smugglers(Deck deck, int credit, int steps, int cardLevel, int firePower, List<Integer> rewardLoad, int loadLoss) {
        super(deck, credit, steps, cardLevel, firePower);
        this.rewardLoad = rewardLoad;
        this.loadLoss = loadLoss;
    }

    public void smugglers(Gameboard gameBoard){
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            double passengerPower= rocket.getRocketPlayer().getMyBoard().checkFirePower();
            if(passengerPower>firePower){
                rocket.getRocketPlayer().getMyBoard().checkStorage(rewardLoad);
                gameBoard.movePlayer(rocket, steps);
                return;
            }
            else if(passengerPower<firePower){
                rocket.getRocketPlayer().getMyBoard().removeStorage(loadLoss);
            }
        }
    }
}
