import java.util.List;

public class Card {
    private Deck deck;
    public int credit;
    public int steps;
    public int cardLevel;
    public boolean isAccessible;


    // costruttore completo con parametri
    public Card(Deck deck, int credit, int steps, int cardLevel) {
        this.deck = deck;
        this.credit = credit;
        this.steps = steps;
        this.cardLevel = cardLevel;


    }

    public Card(List<Card> gameDeck) {
    }

    public Card(Deck deck, int credit, int steps) {
    }


    // metodi getter e setter
    public int getLevel() {
        return cardLevel;
    }


    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }




    // metodo toString (facoltativo ma utile)
    @Override
    public String toString() {
        return "Card{" +
                "deck=" + deck +
                ", credit=" + credit +
                ", steps=" + steps +

                '}';
    }
}
