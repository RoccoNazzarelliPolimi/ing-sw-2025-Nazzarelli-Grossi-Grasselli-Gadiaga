public class AbandonedStation extends Card {

    private int[] rewardLoadArray;
    private int requiredPassengers;


    //costruttore
    public AbandonedStation(Deck deck, int credit, int steps){
    super(deck, credit, steps);
        this.requiredPassengers = requiredPassengers;
        this.rewardLoadArray = rewardLoadArray;

}

    public void AbandonedStation(Storage storage, Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            if (rocket.getRocketPlayer().getMyBoard().checkPassangersPower() > requiredPassengers) {
                if (ask()) { // controller per chiedere se il player vuole
                    gameBoard.movePlayer(rocket, steps);
                    //load
                    return;
                }
            }


        }
    }

    public boolean ask(){ //giusto per non fare errore
        return true;
    }
    public int getLoad() {
        return 0;
    }
}