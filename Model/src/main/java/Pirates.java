import java.util.Map;

public class Pirates extends Enemies{
    private Map<Integer, Integer> shootsMap;

    public Pirates() {
        this.shootsMap = new java.util.HashMap<>();
    }

    public int dices() {
        // Simulazione del lancio di un dado (valore da 1 a 6)
        return (int) (Math.random() * 6) + 1;
    }

    public boolean checkBoard() {
        // Implementazione per controllare lo stato della board
        return false;
    }

    public void attackBoard() {
        // Implementazione per attaccare la board
    }

    public boolean checkShield() {
        // Implementazione per controllare se c'è uno scudo attivo
        return false;
    }

    public void deleteTiles() {
        // Implementazione per eliminare le tessere
    }
}