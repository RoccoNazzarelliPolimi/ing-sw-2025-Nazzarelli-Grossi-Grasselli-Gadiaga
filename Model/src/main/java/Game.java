import java.util.Collections;
public class Game {
    // Attributi della classe

    private int clessidraRound;
    private int numPlayers;
    private Deck deckGame;
    private Gameboard gameBoard;

    // Costruttore
    public Game(int numPlayers) {
        this.numPlayers = numPlayers;
        this.deckGame = new Deck();
        this.gameBoard = new Gameboard(deckGame);
    }

    // Metodo per iniziare il gioco,
    public void startGame() {
        gameBoard.startHourglass();
        System.out.println("Game starting");
    }


    // Metodo per impostare il mazzo di carte di gioco
    public Deck setDeck() {
        this.deckGame = new Deck();
        deckGame.shuffleMainDeck();
        System.out.println("Deck created");
        return deckGame;

    }



    // Metodo per ottenere i giocatori
    public Rocket[] getPlayers() {
        return gameBoard.getRocketArray();
    }

    // Metodo per verificare il vincitore
    //da implementare il caso in cui un giocatore viene eliminato (probabilmente non sarebbe più segnato sul rocketArray)
    public Player checkWinner() {
        Rocket rocketsArray[] = gameBoard.getRocketArray();
        double max = 0;
        Player winner = null;
        for (Rocket rocket : rocketsArray) {
            double current= rocket.getRocketPlayer().getScore();
            if (current>max){
                max=current;
                winner = rocket.getRocketPlayer();
            }
        }
        return winner;
    }

    // Metodo per pescare una carta dal mazzo
    public Card getCard() {
        return this.deckGame.drawCard();
    }
}