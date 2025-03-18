public class AbandonedShip extends Card{
    private int passengerLoss;

    public AbandonedShip(Deck deck, int credit, int steps) {
        super(deck, credit, steps);
        this.passengerLoss = passengerLoss;
    }

    public void AbandonedShip(Rocket rocketsArray[], Gameboard gameBoard) {
        for (Rocket rocket : rocketsArray) {
            if(rocket.getPlayer().getMyBoard().checkPassangersPower()>passengerLoss){//maggiore perchè ti deve rimanere almeno un astronauta
                if(ask()){//chiede al giocatore se vuole giocare la carta
                    rocket.getPlayer().getMyBoard().modifyPassengerPower(passengerLoss);
                    rocket.getPlayer().addScore(credit);
                    gameBoard.movePlayer(rocket, steps);
                }
            }
        }
    }
    public boolean ask(){ //giusto per non fare errore
        return true;
    }
}
