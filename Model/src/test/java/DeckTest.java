import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    @Test
    public void shuffleMainDeck() {
        Map<Integer, List<Integer>> planetCargo = new HashMap<>();
        planetCargo.put(1, List.of(1, 2, 3));
        planetCargo.put(2, List.of(2, 5, 6));

        List<Integer> rewardLoad1 = new ArrayList<>();
        rewardLoad1.add(4);
        rewardLoad1.add(3);
        rewardLoad1.add(3);
        List<Integer> rewardLoad2 = new ArrayList<>();
        rewardLoad2.add(3);
        rewardLoad2.add(2);
        rewardLoad2.add(1);

        Deck gamedeck = new Deck();
        Deck mainDeck = new Deck();
        Card carta1 = new AbandonedShip(gamedeck, 3,-1,2, 2);
        Card carta2 = new Planets(gamedeck, 0 , 3, 1, planetCargo);
        Card carta3 = new Smugglers(gamedeck, 0, 1, 2, 8, rewardLoad1, 3);
        Card carta4 = new AbandonedStation(gamedeck, 0, 2, 2, 8, rewardLoad2);
        mainDeck.addCard(carta1);


    }

    @Test
    public void createSubDecks() {
        Deck deck = new Deck();

    }

    @Test
    public void mergeDecks() {
    }

    @Test

    //testo se pescando una carta ritorna la carta giusta del gamedeck
    public void drawCard() {
        Deck deck = new Deck();
        Card carta1 = new Card(null,1, 2, 2);
        Card carta2 = new Card(null,3, 0, 1);

        deck.drawCard();

    }

    @Test
    public void setDeck() {
    }
}