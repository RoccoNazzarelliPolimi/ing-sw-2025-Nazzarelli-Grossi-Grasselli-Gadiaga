import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pirates extends Enemies{
    private Map<Integer, Integer> shootsMap; //size(1 small, 2 big), direction (1sx, 2up, 3dx, 4down)

    //costruttore
    public Pirates(Deck deck, int credit, int steps, int firePower,Map<Integer, Integer> shootsMap){
        super(deck, credit, steps, firePower);
        this.shootsMap = new HashMap<>();
    }

    public void pirates(Gameboard gameBoard){
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            double passengerPower= rocket.getRocketPlayer().getMyBoard().checkFirePower();
            if(passengerPower>firePower){
                rocket.getRocketPlayer().addScore(credit);
                gameBoard.movePlayer(rocket, steps);
                return;
            }
            else if(passengerPower<firePower){
               rocket.getRocketPlayer().getMyBoard().shoot(shootsMap);
            }
        }
    }
}