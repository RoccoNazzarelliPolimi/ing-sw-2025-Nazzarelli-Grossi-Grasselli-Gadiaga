public class Rocket {
    private String color;
    private Player rocketPlayer;
    private int boardLocation;
    private int numRounds;

    // Costruttore
    public Rocket(Player rocketPlayer, int boardLocation, int order, int numRounds) {
        this.boardLocation = boardLocation;
        this.rocketPlayer = rocketPlayer;
        this.numRounds = numRounds;
    }

    public String getColor() {
        return color;
    }
    public Player getPlayer() {
        return rocketPlayer;
    }
    public int getBoardLocation() {
        return boardLocation;
    }
    public int getNumRounds() {
        return numRounds;
    }
}

