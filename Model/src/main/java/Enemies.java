public class Enemies extends Card{
    public int firePower;

    //costruttore
    public Enemies(Deck deck, int credit, int steps, int cardLevel,  int firePower){
        super(deck, credit, steps, cardLevel);
        this.firePower = firePower;
    }
}