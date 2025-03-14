import java.util.ArrayList;
import java.util.List;

public class Deck {
        private Card [] Deck1;
        private Card [] Deck2;
        private Card [] Deck3;
        private Card [] mainDeck;
        private List<Card>  gameDeck;

        public Deck (){
                this.mainDeck = new Card[40];
                this.Deck1 = new Card[3];
                this.Deck2 = new Card[3];
                this.Deck3 = new Card[3];
                this.gameDeck = new ArrayList<>();
        }

        // Metodo che inizializza mainDeck con carte generate
        public void setDeck() {
                // Inizializziamo le 40 carte del mainDeck
                for (int i = 0; i < mainDeck.length; i++) {
                        mainDeck[i] = new Card(/* inserire parametri se necessari */);
                }

                // Copiamo le carte da mainDeck nella lista gameDeck
                Collections.addAll(gameDeck, mainDeck);
        }

        // Metodo per mischiare il deck di gioco
        public void shuffleDeck() {
                Collections.shuffle(this.gameDeck);
        }

        // Metodo per pescare una carta dal deck
        public Card drawCard() {
                if (this.gameDeck.isEmpty()) {
                        System.out.println("Il deck è vuoto! Non posso pescare altre carte.");
                        return null;
                }
                return this.gameDeck.remove(0);  // rimuove e restituisce la prima carta
        }
}
