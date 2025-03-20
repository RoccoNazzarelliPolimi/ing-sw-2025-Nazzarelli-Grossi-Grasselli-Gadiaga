public class Enemies extends Card{
    public int firePower;

    //costruttore
    public Enemies(Deck deck, int credit, int steps,  int firePower){
        super(deck, credit, steps);
        this.firePower = firePower;
    }
}