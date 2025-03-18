import java.util.Map;

public class MeteorSwarm extends Card {
    private Map<String, Object> meteoriteMap;

    // Costruttore vuoto (aggiungilo solo se necessario)
    public MeteorSwarm() {
        // inizializzazione eventuale della mappa
    }

    // Metodo per controllare lo scudo
    public void checkShield() {
        // logica per controllare lo scudo
    }

    // Metodo per gestire il lancio dei dadi
    public void rollDice() {
        // logica per il lancio dei dadi
    }

    // Metodo per attaccare la board di gioco
    public void attackBoard() {
        // logica per attaccare la board
    }

    // Metodo per controllare la situazione della board dopo l'attacco
    public void checkBoard() {
        // logica per controllare la board
    }

    // Metodo per verificare lo stato del trapano (drill)
    public void checkDrill() {
        // logica per verificare lo stato del drill
    }

    // Metodo per eliminare delle tessere dalla board
    public void deleteTiles() {
        // logica per eliminare tessere
    }

    // Getter e Setter per meteoriteMap, se necessari
    public Map<String, Object> getMeteoriteMap() {
        return meteoriteMap;
    }

    public void setMeteoriteMap(Map<String, Object> meteoriteMap) {
        this.meteoriteMap = meteoriteMap;
    }

    public class Gameboard {
        private int[] pathArray;
        private Rocket[] rocketArray;

        private int hourglassClock;
        private int hourglassRound;
        private Deck deck;

        // Costruttore
        public Gameboard(int hourglassClock, int hourglassRound, Deck deck) {
            this.pathArray = new int[40]; // 40 caselle sulla board
            this.rocketArray = new Rocket[4]; // Posizione dei 4 giocatori (inizialmente a 0)
            this.hourglassClock = hourglassClock;
            this.hourglassRound = hourglassRound;
            this.deck = deck;
        }

        //metodo per muovere un giocatore, da implementare

        public void movePlayer(Rocket rocket, int steps) {
            int rocketId = rocket.getRocketId();



            }



        }
}
