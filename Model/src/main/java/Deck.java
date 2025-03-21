import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
        private Card [] Deck1;
        private Card [] Deck2;
        private Card [] Deck3;
        private Card [] Deck4;
        private Card [] mainDeck; //mazzo generale da 40 carte
        private List <Card>  gameDeck; //mazzo di gioco da 12 carte
        private Random random;

        public Deck (){
                this.mainDeck = new Card[40];
                this.Deck1 = new Card[3];
                this.Deck2 = new Card[3];
                this.Deck3 = new Card[3];
                this.Deck4 = new Card[3];
                this.gameDeck = new ArrayList<>();
                this.random = new Random();
        }

        // Metodo per mischiare il deck di gioco da 40 carte
        public void shuffleMainDeck() {
                Collections.shuffle(gameDeck, random);
        }



        //metodo per creare 4 subdeck
        public void createSubDecks() {

                List<Card> tempDeck = new ArrayList<> ();
               // prendo 12 carte del main deck e le mischio
                for (int i=0; i < 12; i++){
                        tempDeck.add(mainDeck[i]);
                }

                //popolo i 4 mazzi
                for (int i = 0; i < 3; i++) {
                        Deck1[i] = tempDeck.remove(0);
                }
                for (int i = 0; i < 3; i++) {
                        Deck2[i] = tempDeck.remove(0);
                }
                for (int i = 0; i < 3; i++) {
                        Deck3[i] = tempDeck.remove(0);
                }
                for (int i = 0; i < 3; i++) {
                        Deck4[i] = tempDeck.remove(0);
                }

                //rendo il quarto mazzo inaccessibile per la prima parte del gioco
                for (Card card : Deck4) {
                        card.accessible = false;
                }

        }

        //metodo per unire i 4 mazzi nel gameDeck da 12 carte e per mischiarlo con la giusta procedura
        public void mergeDecks(){
                //aggiungo carte nel mazzo di gioco
                Collections.addAll(gameDeck, Deck1);
                Collections.addAll(gameDeck, Deck2);
                Collections.addAll(gameDeck, Deck3);
                Collections.addAll(gameDeck, Deck4);

                //Mischio il mazzo di gioco fino a quando la prima carta è di livello II (dalle regole del gioco)
                do {
                        Collections.shuffle(gameDeck, random);

                } while (gameDeck.get(0).getLevel() != 2);

        }




        // Metodo per pescare una carta dal deck
        public Card drawCard() {
                if (this.gameDeck.isEmpty()) {
                        System.out.println("Il deck è vuoto! Non posso pescare altre carte.");
                        return null;
                }
                return this.gameDeck.remove(0);  // rimuove e restituisce la prima carta
        }

        // forse inutile non so
        public void setDeck() {
                for (int i = 0; i < mainDeck.length; i++) {
                        mainDeck[i] = new Card(gameDeck); // Supponendo che Card abbia un costruttore che accetta un numero
                }
        }


        }



