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
        }

        public setDeck()
        {

        }


        public Card drawCard()
        {
                Card cardDrawn = new Card();

                cardDrawn = this.gameDeck.get(0);
                this.gameDeck.remove(0);

                return cardDrawn;
        }

        public void removeCard()
        {

        }
}
