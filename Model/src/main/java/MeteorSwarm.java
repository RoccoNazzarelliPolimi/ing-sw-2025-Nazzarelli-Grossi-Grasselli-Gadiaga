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
}
