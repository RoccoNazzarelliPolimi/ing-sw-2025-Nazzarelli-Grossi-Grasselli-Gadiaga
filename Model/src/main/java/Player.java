public class Player {

   private String nickname;
   private double score;
   private int color;
   private PlayerBoard myBoard;
   private Rocket myRocket;


   public Player(String nickname, Double score, int color, PlayerBoard myBoard, Rocket myRocket) {

       this.nickname = nickname;
       this.score = score;
       this.color = color;
       this.myBoard = myBoard;
       this.myRocket = myRocket;

   }

   private Card getCard()
   {}


   private double totalFiringPower()
   {}

   private double totalSpeedPower ()
   {}
}
