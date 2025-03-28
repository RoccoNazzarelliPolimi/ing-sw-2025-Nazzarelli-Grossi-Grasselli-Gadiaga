import junit.framework.TestCase;

import java.util.*;

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
        Tile tile = new Pipe(new int[4], 9, 4, playerBoard);

        player.setMyBoard(playerBoard);

        playerBoard.addTile(tile, 1, 1);
    }
    /**
     * Test that verifies the addition of cargo to the playerboard
     * 1: The storages are empty and there is a red one
     */
    public void testCheckStorage1(){
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        player.setMyBoard(playerBoard);

        Tile tile = new CentralHousingUnit(new int[]{3, 3, 3, 3}, -1, -1, playerBoard, 2);
        playerBoard.addTile(tile, 7, 7);
        Tile tile1= new Storage(new int[]{1, 2, 3, 2}, -1, -1, playerBoard, 2, 0, false, new ArrayList<>() );
        playerBoard.addTile(tile1, 7, 8);
        Tile tile2= new Storage(new int[]{0, 3, 3, 0}, -1, -1, playerBoard, 1, 0, true, new ArrayList<>() );
        playerBoard.addTile(tile2, 8, 7);

        List<Integer> load = new ArrayList<>(Arrays.asList(4, 3, 1));

        playerBoard.checkStorage(load);
    }
    /**
     * Test that verifies the addition of cargo to the playerboard
     * 2: The storages are empty but there isn't a red storage
     * It checks if, since it cannot add the red cargo anywhere,
     * it deletes it form the list of cargo to add
     */
    public void testCheckStorage2(){
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        player.setMyBoard(playerBoard);

        List<Integer> load = new ArrayList<>(Arrays.asList(4, 3, 1));

        Tile tile3= new Storage(new int[]{1, 2, 3, 2}, -1, -1, playerBoard, 2, 0, false, new ArrayList<>() );
        playerBoard.addTile(tile3, 7, 8);

        playerBoard.checkStorage(load);
    }
    /**
     * Test that verifies the addition of cargo to the playerboard
     * 3: The storages are full, so it checks if the less valueable
     * cargo do get deleted in favor of the new more valueable ones
     */
    public void testCheckStorage3(){
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        player.setMyBoard(playerBoard);

        List<Integer> load = new ArrayList<>(Arrays.asList(4, 3, 1));

        Tile tile4= new Storage(new int[]{1, 2, 3, 2}, -1, -1, playerBoard, 2, 0, false, new ArrayList<>() );
        playerBoard.addTile(tile4, 7, 8);
        Tile tile5= new Storage(new int[]{0, 3, 3, 0}, -1, -1, playerBoard, 1, 0, true, new ArrayList<>() );
        playerBoard.addTile(tile5, 8, 7);

        List<Integer> load1 = new ArrayList<>(Arrays.asList(1,1,1));
        playerBoard.checkStorage(load1);
        playerBoard.checkStorage(load);
    }
    /**
     * This test verifies that the tile hit is actually removed, unless it is protected by a shield
     */
    public void testShoot(){
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        player.setMyBoard(playerBoard);

        //shootsMap
        List<Pair> shootsMap = new ArrayList<>(Arrays.asList(
                new Pair(1, 1),
                new Pair(1, 2),
                new Pair(1, 3),
                new Pair(1, 4),
                new Pair(2, 1),
                new Pair(2, 2),
                new Pair(2, 3),
                new Pair(2, 4)
        ));

        //creo una PlayerBoard per testare
        Tile tile = new CentralHousingUnit(new int[]{3, 3, 3, 3}, -1, -1, playerBoard, 2);
        playerBoard.addTile(tile, 7, 7);
        Tile tile1= new Drill (new int[]{3, 3, 3, 3}, -1,-1, playerBoard, 1, 1, new int[]{0, 1, 0, 0});
        playerBoard.addTile(tile1, 7, 8);
        Tile tile2= new Shield (new int[]{3, 3, 3, 3}, -1,-1, playerBoard, new int[]{1, 1, 0, 0}); //scudo attivo sx e up
        playerBoard.addTile(tile2, 7, 6);

        playerBoard.shoot(shootsMap);
    }

    /**
     * This test verifies that the tile hit is actually removed,
     * unless it is protected by a shield or bounces off ( for size 1)
     * or (for size 2) there is a drill in that direction
     */
    public void testMeteorShoot(){
        Rocket rocket = new Rocket(null, 5, 1, 0);
        Player player = new Player("Rocky", 0.0, "green", null, rocket);
        PlayerBoard playerBoard = new PlayerBoard(9, 11, player);
        player.setMyBoard(playerBoard);

        //shootsMap
        int size1= 1;
        int size2= 2;
        int direction= 2; //up
        int dice1= 6;
        int dice2= 7;
        int dice3= 8;
        //creo una PlayerBoard per testare
        Tile tile = new CentralHousingUnit(new int[]{3, 3, 3, 3}, -1, -1, playerBoard, 2);
        playerBoard.addTile(tile, 7, 7); //connettore esposto dall'alto
        Tile tile1= new Drill (new int[]{3, 0, 3, 3}, -1,-1, playerBoard, 1, 1, new int[]{0, 1, 0, 0});
        playerBoard.addTile(tile1, 7, 8);
        Tile tile2= new Shield (new int[]{0, 0, 3, 0}, -1,-1, playerBoard, new int[]{1, 1, 0, 0}); //scudo attivo sx e up
        playerBoard.addTile(tile2, 7, 6); // rimbalzo dall'alto

        playerBoard.meteorShoot(size1, direction, dice1); //small, bounces off
        playerBoard.meteorShoot(size1, direction, dice2); //small, protected with shield
        playerBoard.meteorShoot(size2, direction, dice3); //big, shooted
        playerBoard.meteorShoot(size2, direction, dice1); //deletes tile
    }
}