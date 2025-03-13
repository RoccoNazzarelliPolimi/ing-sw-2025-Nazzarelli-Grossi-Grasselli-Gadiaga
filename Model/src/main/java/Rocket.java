public class Rocket {

    private int color;
    private Player rocketPlayer;
    private int order;
    private int numRounds;
    private int boardLocation;
    private int rocketId;

    // Costruttore
    public Rocket(int color, Player rocketPlayer, int boardLocation, int order, int numRounds) {
        this.color = color;
        this.boardLocation = boardLocation;
        this.rocketPlayer = rocketPlayer;
        this.numRounds = numRounds;
        this.order = order;
    }

    // Getter e Setter per color
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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

    // Getter e Setter per rocketId
    public int getRocketId() {
        return rocketId;
    }

    public void setRocketId(int rocketId) {
        this.rocketId = rocketId;
        int i=0;
    }
}

