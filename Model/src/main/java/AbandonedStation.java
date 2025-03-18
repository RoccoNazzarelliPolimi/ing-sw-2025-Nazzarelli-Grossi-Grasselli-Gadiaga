public class AbandonedStation extends Card {

    private int[] rewardLoadArray;
    private int requiredPassengers;


    //costruttore
    public AbandonedStation(Deck deck, int credit, int steps){
    super(deck, credit, steps);
        this.requiredPassengers = requiredPassengers;
        this.rewardLoadArray = rewardLoadArray;

}

    public void AbandonedStation(Rocket rocketArray[], Storage storage, Gameboard gameboard) {
        for (Rocket rocket : rocketArray) {
            if (rocket.getPlayer().getMyBoard().checkPassangersPower() > requiredPassengers) {
                if (ask()) // controller per chiedere se il player vuole
                {
                    gameboard.movePlayer(rocket, steps);
                }





                }
            }


        }
        public boolean ask () {
            return false;
        }
        public int getLoad () {
            return 0;
        }
    }