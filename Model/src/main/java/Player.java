public class Player {

    private String nickname;
    private double score;
    private String color;
    private PlayerBoard myBoard;
    private Rocket myRocket;


    public Player(String nickname, Double score, String color, PlayerBoard myBoard, Rocket myRocket) {

        this.nickname = nickname;
        this.score = score;
        this.color = color;
        this.myBoard = myBoard;
        this.myRocket = myRocket;

    }

    public double getScore()
    {
        return this.score;
    }

    public void setScore(double new_score)
    {
        this.score =  new_score;
    }

    public String getColor()
    {
        return this.color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
}
