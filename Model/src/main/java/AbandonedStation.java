import java.util.List;
import java.util.ArrayList;

public class AbandonedStation extends Card {

    private List<Integer> rewardLoad;
    private int requiredPassengers;


    //costruttore
    public AbandonedStation(Deck deck, int credit, int steps,  int requiredPassengers,  List<Integer> rewardLoad) {
    super(deck, credit, steps);
        this.requiredPassengers = requiredPassengers;
        this.rewardLoad =new ArrayList<>();
    }

    public void AbandonedStation(Storage storage, Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            if (rocket.getRocketPlayer().getMyBoard().checkPassengersPower() > requiredPassengers) {
                if (ask()) { // controller per chiedere se il player vuole
                    gameBoard.movePlayer(rocket, steps);
                    rocket.getRocketPlayer().getMyBoard().checkStorage(rewardLoad);
                    return;
                }
            }


        }
    }

    public boolean ask(){ //giusto per non fare errore
        return true;
    }
}