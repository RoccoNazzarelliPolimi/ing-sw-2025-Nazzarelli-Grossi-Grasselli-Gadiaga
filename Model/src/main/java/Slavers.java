import java.util.ArrayList;
import java.util.List;

// Classe Slavers
public class Slavers extends Enemies {
    private int passengerLoss;

    //costruttore
    public Slavers(Deck deck, int credit, int steps, int firePower, int passengerLoss){
        super(deck, credit, steps, firePower);
        this.passengerLoss = passengerLoss;
    }
    public void slavers(Gameboard gameBoard){
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            double passengerPower= rocket.getRocketPlayer().getMyBoard().checkFirePower();
            if(passengerPower>firePower){
                rocket.getRocketPlayer().addScore(credit);
                gameBoard.movePlayer(rocket, steps);
                return;
            }
            else if(passengerPower<firePower){
                rocket.getRocketPlayer().getMyBoard().modifyPassengerPower(passengerLoss);
            }
        }
    }
}
