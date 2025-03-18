public class Gameboard{
    private int[] pathArray;
    private Rocket[] rocketArray;

    private int hourglassClock;
    private int hourglassRound;
    private Deck deck;

    // Costruttore
    public Gameboard(int hourglassClock, int hourglassRound, Deck deck) {
        this.pathArray = new int[40]; // 40 caselle sulla board
        this.rocketArray = new Rocket[4]; // Posizione dei 4 giocatori (inizialmente a 0)
        this.hourglassClock = hourglassClock;
        this.hourglassRound = hourglassRound;
        this.deck = deck;
    }

    //metodo per muovere un giocatore, da implementare

    public void movePlayer(Rocket rocket, int steps) {
        int rocketId = rocket.getRocketPlayer().;




    }



}



// Metodo per verificare se un giocatore ha superato un altro
public boolean doubleRound(int player) {
    int pos = rocketArray[player];
    for (int i = 0; i < rocketArray.length; i++) {
        if (i != player && pos > rocketArray[i]) {
            System.out.println("Giocatore " + player + " ha superato il giocatore " + i);
            return true;
        }
    }
    return false;
}

// Metodi getter per accedere ai dati
public Deck getDeck() {
    return deck;
}

public int[] getPathArray() {
    return pathArray;
}

public int[] getRocketArray() {
    return rocketArray;


}
}