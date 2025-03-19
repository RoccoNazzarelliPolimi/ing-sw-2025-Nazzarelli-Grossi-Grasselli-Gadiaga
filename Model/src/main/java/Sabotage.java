public class Sabotage extends Card{
    // Constructor
    public Sabotage(Deck deck, int credit, int steps) {
        super(deck, credit, steps); // Chiamata esplicita al costruttore di Card
    }
    public void sabotage(Gameboard gameBoard) {
        Rocket rocketsArray[] = gameBoard.getRocketArray();
        int min = 0;
        Rocket loser=null;
        for (Rocket rocket : rocketsArray) {
            int current= rocket.getRocketPlayer().getMyBoard().checkPassangersPower();
            if (current<min) {
                min=current;
                loser= rocket;
            }
        } //in loser ho salvato il rocket del giocatore con minor equipaggio
        //tiro dei dadi e distruzione nave ecc
    }
}