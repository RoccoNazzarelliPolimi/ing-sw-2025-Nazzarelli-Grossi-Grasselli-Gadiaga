public class Epidemic extends Card{
    // Costruttore che chiama il costruttore di Card
    public Epidemic(Deck deck, int credit, int steps) {
        super(deck, credit, steps); // Chiamata esplicita al costruttore di Card
    }

    public void epidemic(Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            int passengerLoss = rocket.getRocketPlayer().getMyBoard().checkCabinConnection();
            rocket.getRocketPlayer().getMyBoard().modifyPassengerPower(passengerLoss);
        }
    }

}
