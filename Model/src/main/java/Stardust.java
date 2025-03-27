public class Stardust extends Card {
    // Costruttore che chiama il costruttore di Card
    public Stardust(Deck deck, int credit, int steps, int cardLevel) {
        super(deck, credit, steps); // Chiamata esplicita al costruttore di Card
    }

    public void stardust(Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            int steps= rocket.getRocketPlayer().getMyBoard().countOpenConnectors();
            gameBoard.movePlayer(rocket, steps);
        }
    }

}
