public class Player {

   private String nickname;
   private double score;
   private int color;
   private PlayerBoard myBoard;
   private Rocket myRocket;


   public Player(String nickname, Double score, int color, PlayerBoard myBoard, Rocket myRocket) {

       this.nickname = nickname;
       this.score = 0;
       this.color = color;
       this.myBoard = myBoard;
       this.myRocket = myRocket;

   }

   public double getScore() {
       return score;
   }

    public int getColor() {
        return color;
    }
    public String getNickname() {
        return nickname;
    }
    public PlayerBoard getMyBoard() {
        return myBoard;
    }
    public Rocket getMyRocket() {
       return myRocket;
    }

}
