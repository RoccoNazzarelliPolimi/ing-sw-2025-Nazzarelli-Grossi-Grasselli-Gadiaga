public class AbandonedShip extends Card{
    private int passengerLoss;

    public AbandonedShip(Deck deck, int credit, int steps,  int passengerLoss, int cardLevel) {
        super(deck, credit, steps, cardLevel );
        this.passengerLoss = passengerLoss;
    }

    public void AbandonedShip( Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            if(rocket.getRocketPlayer().getMyBoard().checkPassengersPower()>passengerLoss){//maggiore perchè ti deve rimanere almeno un astronauta
                if(ask()){//chiede al giocatore se vuole giocare la carta
                    rocket.getRocketPlayer().getMyBoard().modifyPassengerPower(passengerLoss);
                    rocket.getRocketPlayer().addScore(credit);
                    gameBoard.movePlayer(rocket, steps);
                    return;
                }
            }
        }
    }
    public boolean ask(){ //giusto per non fare errore
        return true;
    }
}
