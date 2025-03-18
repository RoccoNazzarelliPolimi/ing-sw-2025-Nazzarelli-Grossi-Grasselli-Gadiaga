public class Rocket {

    private Player rocketPlayer;
    private int order;
    private int numRounds;
    private int boardLocation;

    // Costruttore
    public Rocket(Player rocketPlayer, int boardLocation, int order, int numRounds) {
        this.boardLocation = boardLocation;
        this.rocketPlayer = rocketPlayer;
        this.numRounds = numRounds;
        this.order = order;
    }

    // Getter e Setter per rocketPlayer
    public Player getRocketPlayer() {
        return rocketPlayer;
    }

    public void setRocketPlayer(Player rocketPlayer) {
        this.rocketPlayer = rocketPlayer;
    }

    // Getter e Setter per order
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    // Getter e Setter per numRounds
    public int getNumRounds() {
        return numRounds;
    }

    public void setNumRounds(int numRounds) {
        this.numRounds = numRounds;
    }

    // Getter e Setter per boardLocation
    public int getBoardLocation() {
        return boardLocation;
    }

    public void setBoardLocation(int boardLocation) {
        this.boardLocation = boardLocation;
    }

}

