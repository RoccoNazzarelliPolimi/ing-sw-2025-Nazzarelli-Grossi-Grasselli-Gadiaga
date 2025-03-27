public class Player {

    private String nickname;
    private double score;
    private String color;
    private PlayerBoard myBoard;
    private Rocket myRocket;


    public Player(String nickname, Double score, String color, PlayerBoard myBoard, Rocket myRocket) {
        this.nickname = nickname;
        this.score = 0;
        this.color = color;
        this.myBoard = myBoard;
        this.myRocket = myRocket;
    }

    public String getNickname(){
        return nickname;
    }
    public double getScore(){
        return score;
    }
    public void addScore(int score){
        this.score += score;
    }
    public String getColor(){
        return color;
    }
    public PlayerBoard getMyBoard(){
        return myBoard;
    }
    public Rocket getMyRocket(){
        return myRocket;
    }
    public void setMyBoard(PlayerBoard myBoard){
        this.myBoard = myBoard;
    }

}
