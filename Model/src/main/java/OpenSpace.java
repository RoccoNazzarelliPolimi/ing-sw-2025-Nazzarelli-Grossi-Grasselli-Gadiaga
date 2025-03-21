public class OpenSpace extends Card{
    // Costruttore che chiama il costruttore di Card
    public OpenSpace(Deck deck, int credit, int steps, int cardLevel) {
        super(deck, credit, steps, cardLevel); // Chiamata esplicita al costruttore di Card
    }

    public void openSpace(Gameboard gameBoard) {
        Rocket rocketsArray[]=gameBoard.getRocketArray();
        for (Rocket rocket : rocketsArray) {
            int steps = rocket.getRocketPlayer().getMyBoard().checkHeaterPower(); // Calcola gli step da fare
            gameBoard.movePlayer(rocket, steps); //controllare che il metodo richeda questo
        }
    } //ho fatto il metodo che fa tutte le cose di openspace in ordine così che quando si tira fuori questa carta, si manda questo metodo che fa tutto
}
