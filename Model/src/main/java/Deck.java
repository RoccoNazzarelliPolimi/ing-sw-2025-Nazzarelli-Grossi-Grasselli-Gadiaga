import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
        private Card [] Deck1;
        private Card [] Deck2;
        private Card [] Deck3;
        private Card [] Deck4;
        private Card [] mainDeck;
        private List<Card>  gameDeck; //mazzo di gioco
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


        // Metodo per mischiare il deck di gioco
        public void shuffleDeck() {
                Collections.shuffle(gameDeck, random);
        }



        //metodo per creare 4 subdeck
        public int[] createSubDecks; {
                //seleziono 4 gruppi da 3 carte
                List<Card> tempDeck = new ArrayList<>();
                Collections.addAll(tempDeck, mainDeck);
                Collections.shuffle(tempDeck, random);

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

                //aggiungo carte nel mazzo di gioco
                Collections.addAll(gameDeck, Deck1);
                Collections.addAll(gameDeck, Deck2);
                Collections.addAll(gameDeck, Deck3);
                Collections.addAll(gameDeck, Deck4);

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



