import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
        private List<Card> deck1;
        private List<Card> deck2;
        private List<Card> deck3;
        private List<Card> deck4;
        private List <Card> mainDeck; //mazzo generale da 40 carte
        private List <Card>  gameDeck; //mazzo di gioco da 12 carte
        private Random random;

        public Deck (){
                this.mainDeck = new ArrayList<>();
                this.deck1 = new ArrayList<>();
                this.deck2 = new ArrayList<>();
                this.deck3 = new ArrayList<>();
                this.deck4 = new ArrayList<>();
                this.gameDeck = new ArrayList<>();
                this.random = new Random();
        }

        //metodo che popolerà il mainDeck (lo farà il controller)
        public void initializeMainDeck(){

                // Il controller chiamerà deck.addToMainDeck per popolare il mazzo
        }

        //aggiunge le 40 carte avventura al mainDeck
        public void addToMainDeck(Card card){
                mainDeck.add(card);
        }

        // Metodo per mischiare il mainDeck
        public void shuffleMainDeck() {
                Collections.shuffle(mainDeck, random);
        }


        //metodo per creare 4 subdeck dalle 12 carte prelevate da MainDeck
        public void createSubDecks() {
                List<Card> level1Cards = new ArrayList<>();
                List<Card> level2Cards = new ArrayList<>();
                //seleziona 8 carte di livello II e 4 di livello 1 da MainDeck
                for (Card c : mainDeck) {
                        if (c.getLevel() == 1 && level1Cards.size() < 4) {
                                level1Cards.add(c);
                        } else if (c.getLevel() == 2 && level2Cards.size() < 8) {
                                level2Cards.add(c);
                        }

                        if (level1Cards.size() == 4 && level2Cards.size() == 8 ) {
                                break;
                        }

                        //unisco e le mischio
                        List<Card> twelveCards = new ArrayList<>();
                        twelveCards.addAll(level1Cards);
                        twelveCards.addAll(level2Cards);
                        Collections.shuffle(twelveCards, random);

                List<Card> tempDeck = new ArrayList<> ();

                // Divido in 4 subdecks con 2 carte di livello 2 + 1 di livello 1
                List<List<Card>> subDecks = List.of(deck1, deck2, deck3, deck4);
                for (List<Card> subDeck : subDecks) {
                        int level1 = 0;
                        int level2 = 0;

                        while (subDeck.size() < 3 && !twelveCards.isEmpty()) {
                                Card card = twelveCards.remove(0);
                                if (c.getLevel() == 1 && level1 < 1 ) {
                                        subDeck.add(c);
                                        level1++;
                                } else if (c.getLevel() == 2 && level2 < 1 ) {
                                        subDeck.add(c);
                                        level2++;
                                } else {
                                        twelveCards.add(card); //altrimenti
                                }


                        }
                }
                for (Card card : deck4) {
                        card.setAccessible(false);
                }

                }


        }

        //unisco i subdecks e mischio fino a che la prima carta è livello II
        public void mergeSubDecks() {
                gameDeck.clear();
                gameDeck.addAll(deck1);
                gameDeck.addAll(deck2);
                gameDeck.addAll(deck3);
                gameDeck.addAll(deck4);

                do {
                        Collections.shuffle(gameDeck, random);
                } while (!gameDeck.isEmpty() && gameDeck.get(0).getLevel() != 2);


        }




        // Metodo per pescare una carta dal deck
        public Card drawCard() {
                if (this.gameDeck.isEmpty()) {
                        System.out.println("Il deck è vuoto! Non posso pescare altre carte.");
                        return null;
                } else {
                       // rimuove e restituisce la prima carta
                        System.out.println("Carta in gioco: " + this.gameDeck.get(0));

                }
                return this.gameDeck.remove(0);
        }

        //utilizzato per il testing di deck
        public void addCard() {
        }


        }



