public class OpenSpace extends Card{
    // Costruttore che chiama il costruttore di Card
    public OpenSpace(Deck deck, int credit, int steps) {
        super(deck, credit, steps); // Chiamata esplicita al costruttore di Card
    }

    public void openSpace(Rocket rocketsArray[]) {
        for (Rocket rocket : rocketsArray) {
            double steps = rocket.getPlayer().getMyBoard().checkHeaterPower(); // Calcola gli step da fare
            movePlayer(rocket, steps); //controllare che il metodo richeda questo
        }
    } //ho fatto il metodo che fa tutte le cose di openspace in ordine così che quando si tira fuori questa carta, si manda questo metodo che fa tutto
}
