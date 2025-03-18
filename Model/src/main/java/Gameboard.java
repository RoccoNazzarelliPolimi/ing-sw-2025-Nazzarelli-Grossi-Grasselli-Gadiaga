public class Gameboard {
    private int[] pathArray;
    private Rocket[] rocketArray;

    private int hourglassClock;
    private int hourglassRound;
    private Deck deck;
    private int hourglassIterator = 0;// n times the hourglass have been flipped
    private boolean timerRunning = false; //check if the timer is active

    // Costruttore
    public Gameboard(int hourglassClock, int hourglassRound, Deck deck) {
        this.pathArray = new int[40]; // 40 caselle sulla board
        this.rocketArray = new Rocket[4]; // Posizione dei 4 giocatori (inizialmente a 0)
        this.hourglassClock = hourglassClock;
        this.hourglassRound = hourglassRound;
        this.deck = deck;
    }

    //metodo per muovere un giocatore, da implementare

    public void movePlayer(Rocket rocket, int steps) {
        int rocketId = rocket.getRocketPlayer().;


    }

    // Metodo per verificare se un giocatore ha superato un altro
    public boolean doubleRound(int player) {
        int pos = rocketArray[player];
        for (int i = 0; i < rocketArray.length; i++) {
            if (i != player && pos > rocketArray[i]) {
                System.out.println("Giocatore " + player + " ha superato il giocatore " + i);
                return true;
            }
        }
        return false;
    }

    // Metodi getter per accedere ai dati
    public Deck getDeck() {
        return deck;
    }

    public int[] getPathArray() {
        return pathArray;
    }

    public int[] getRocketArray() {
        return rocketArray;
    }

    //start the hourclock with thread, va collegata al controller
    public void startHourglass() {
        if (hourglassIterator >= 2) {
            //interazione con controller per iniziare il gioco
            //esempio gameStarted = true;
            return;

        }

        if (timerRunning == true) {
            System.out.println("Timer is active");
            return;
        }
        System.out.println("Hourglass has been flipped");
        timerRunning = true;
        hourglassIterator++;

        //start the thread for the timer,
        new timerTask = new Runnable() {
            public void run() {

                try {
                    Thread.sleep(1000);//wait a second between each iteration
                } catch (InterruptedException e) {
                    System.out.println("Timer interrupted");
                    startHourglass(); //it automatically restarts
                }
                //manca la connessione con il controller per chiedere ai giocatori se girare la clessidra o no


            }
        }
    }
}




