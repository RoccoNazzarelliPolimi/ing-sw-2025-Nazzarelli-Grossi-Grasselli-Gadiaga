import java.util.ArrayList;
import java.util.List;

// Classe Slavers
public class Slavers extends Enemies {
    private int passangerLoss;

    //costruttore
    public Slavers(Deck deck, int credit, int steps, int firePower){
        super(deck, credit, steps, firePower);
        this.passangerLoss = passangerLoss;
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
                rocket.getRocketPlayer().getMyBoard().modifyPassengerPower(passangerLoss);
            }
        }
    }
}
