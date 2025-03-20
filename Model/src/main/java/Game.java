import java.util.Collections;
public class Game {
    // Attributi della classe

    private int clessidraRound;
    private int numPlayers;
    private Deck deckGame;
    private Gameboard gameboard;

    // Costruttore
    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        this.deckGame = new Deck();
        this.gameboard = new Gameboard(deckGame);
    }

    // Metodo per iniziare il gioco,
    public void startGame() {
        gameboard.startHourglass();
        System.out.println("Game starting");
    }


    // Metodo per impostare il mazzo di carte di gioco
    public Deck setDeck() {
        this.deckGame = new Deck();
        deckGame.shuffleDeck();
        System.out.println("Deck created");
        return deckGame;

    }



    // Metodo per ottenere un giocatore (da implementare meglio a seconda della logica del gioco)
    public Player getPlayer() {
        // Logica per ottenere un giocatore
        return null;
    }

    // Metodo per verificare il vincitore
    public void checkWinner(){


        // Logica per determinare il vincitore
    }

    // Metodo per pescare una carta dal mazzo
    public Card getCard() {
        return this.deckGame.drawCard();
    }
}
