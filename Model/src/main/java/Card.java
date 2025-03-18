public class Card {
    private Deck deck;
    public int credit;
    public int steps;

    // costruttore completo con parametri
    public Card(Deck deck, int credit, int steps) {
        this.deck = deck;
        this.credit = credit;
        this.steps = steps;
    }

    // metodi getter e setter
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
