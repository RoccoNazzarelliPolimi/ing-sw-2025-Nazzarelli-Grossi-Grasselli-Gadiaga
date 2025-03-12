public class Rocket {

    private int color;
    private Player rocketPlayer;
    private int order;
    private int numRounds;
    private int boardLocation;

    public Rocket(int color, Player rocketPlayer, int boardLocation, int order, int numRounds)
    {
        this.color = color;
        this.boardLocation = boardLocation;
        this.rocketPlayer = rocketPlayer;
        this.numRounds = numRounds;
        this.order = order;
    }



}
