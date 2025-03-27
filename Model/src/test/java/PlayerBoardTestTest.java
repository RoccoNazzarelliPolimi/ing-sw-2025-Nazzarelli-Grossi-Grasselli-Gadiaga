import junit.framework.TestCase;

public class PlayerBoardTestTest extends TestCase {


    /**
     * Test che verifica l'aggiunta di una tessera (Tile) alla plancia del giocatore (PlayerBoard).
     * Crea un giocatore con un razzo, una plancia 9x11 e una tessera Pipe,
     * poi tenta di aggiungere la tessera nella posizione (1,1) della plancia.
     */
    int a =1;
    public void testAddTile() {
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        Tile tile = new Pipe(new int[4], -1, -1, playerBoard);

        player.setMyBoard(playerBoard);

        playerBoard.addTile(tile, 1, 1);
    }
}