import java.util.Collections;


public class Game {
    // Attributi della classe
    private int clessidraClock;
    private int clessidraRound;
    private int numPlayers;
    private Deck deckGame;

    // Costruttore
    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        this.deckGame = new Deck();
        this.clessidraClock = 0;
        this.clessidraRound = 0;
    }

    // Metodo per iniziare il gioco
    public void startGame() {
        System.out.println("Il gioco è iniziato!");
    }

    // Metodo per impostare il mazzo di carte
    public Deck setDeck() {
        this.deckGame = new Deck();
        return this.deckGame;
    }

    // Metodo per mescolare il mazzo di carte
    public void shuffleDeck() {
        this.deckGame.shuffle();
    }

    // Metodo per ottenere un giocatore (da implementare meglio a seconda della logica del gioco)
    public Player getPlayer() {
        // Logica per ottenere un giocatore
        return null;
    }

    // Metodo per verificare il vincitore
    public void checkWinner() {
        // Logica per determinare il vincitore
    }

    // Metodo per pescare una carta dal mazzo
    public Card getCard() {
        return this.deckGame.drawCard();
    }
}
