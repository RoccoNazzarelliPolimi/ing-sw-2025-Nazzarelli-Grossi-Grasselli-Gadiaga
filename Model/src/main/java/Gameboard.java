import java.util.List;
import java.util.ArrayList;


public class Gameboard {
    private String[] pathArray;
    private Rocket[] rocketArray;
    private int hourglassClock;
    private int hourglassRound;
    private Deck deck;
    private int start_path;
    private int end_path;
     //volte clessidra girata
    private boolean timerRunning = false;


    //Costruttore

    int b;

    public Gameboard (Deck deck) {
        this.pathArray = new String[40]; // 40 caselle sulla board
        this.rocketArray = new Rocket[4]; // Posizione dei 4 giocatori (inizialmente a 0)
        this.hourglassClock = hourglassClock;
        this.hourglassRound = hourglassRound;
        this.deck = deck;
        this.start_path = 0;
        this.end_path = 39;
    }

    //Metodo per muovere un giocatore, da implementare

    public void movePlayer(Rocket rocket, int steps) {

        int stepsHelp = steps;

        int index_rocket = 0;

        for (int i = 0; i < rocketArray.length; i++) {
            if (rocketArray[i].equals(rocket)) {
                index_rocket = i;
            }
        }

        //Implementa il cambio ordine nel sorpasso

        //Fai ciclio anche per steps negativi
        if (stepsHelp > 0) {

            while (stepsHelp > 0) {

                if (rocket.getBoardLocation() + 1 != (this.end_path + 1)) {
                    if (isFree(rocket.getBoardLocation() + 1)) {

                        this.pathArray[rocket.getBoardLocation()] = null;
                        rocket.setBoardLocation(rocket.getBoardLocation() + 1);
                        this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                    } else {

                        int start_jump_index = rocket.getBoardLocation();
                        this.pathArray[start_jump_index] = null;


                        while (!isFree(rocket.getBoardLocation())) {
                            if (rocket.getBoardLocation() + 1 == this.end_path + 1) {
                                rocket.setBoardLocation(this.start_path);
                                if (this.checkNumRounds(this.end_path)) {
                                    this.deletePlayer();
                                }
                            } else {
                                rocket.setBoardLocation(rocket.getBoardLocation() + 1);
                                if (this.checkNumRounds(rocket.getBoardLocation() - 1)) {
                                    this.deletePlayer();
                                }
                            }
                        }

                        this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                    }

                }

                //manca la connessione con il controller per chiedere ai giocatori se girare la clessidra o no!

                if (rocket.getBoardLocation() + 1 == this.end_path + 1) {

                    rocket.setBoardLocation(this.start_path);
                    this.pathArray[this.end_path] = null;

                    while (!isFree(rocket.getBoardLocation())) {
                        if (rocket.getBoardLocation() + 1 == this.end_path + 1) {
                            rocket.setBoardLocation(this.start_path);
                            if (this.checkNumRounds(this.end_path)) {
                                this.deletePlayer();
                            }
                        } else {
                            rocket.setBoardLocation(rocket.getBoardLocation() + 1);
                            if (this.checkNumRounds(rocket.getBoardLocation() - 1)) {
                                this.deletePlayer();
                            }
                        }
                    }

                    this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                }
                stepsHelp--;
            }
        } else {

            while (stepsHelp < 0) {

                if (rocket.getBoardLocation() - 1 != (this.start_path - 1)) {
                    if (isFree(rocket.getBoardLocation() - 1)) {

                        this.pathArray[rocket.getBoardLocation()] = null;
                        rocket.setBoardLocation(rocket.getBoardLocation() - 1);
                        this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                    } else {

                        int start_jump_index = rocket.getBoardLocation();
                        this.pathArray[start_jump_index] = null;


                        while (!isFree(rocket.getBoardLocation() - 1)) {
                            if (rocket.getBoardLocation() - 1 == this.start_path - 1) {
                                rocket.setBoardLocation(this.end_path);
                                if (this.checkNumRounds(this.start_path)) {
                                    this.deletePlayer();
                                }
                            } else {
                                rocket.setBoardLocation(rocket.getBoardLocation() - 1);
                                if (this.checkNumRounds(rocket.getBoardLocation() + 1)) {
                                    this.deletePlayer();
                                }
                            }
                        }

                        this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                    }

                }

                if (rocket.getBoardLocation() - 1 == this.start_path - 1) {

                    rocket.setBoardLocation(this.start_path);
                    this.pathArray[this.end_path] = null;

                    while (!isFree(rocket.getBoardLocation())) {
                        if (rocket.getBoardLocation() - 1 == this.start_path - 1) {
                            rocket.setBoardLocation(this.start_path);
                            if (this.checkNumRounds(this.end_path)) {
                                this.deletePlayer();
                            }
                        } else {
                            rocket.setBoardLocation(rocket.getBoardLocation() - 1);
                            if (this.checkNumRounds(rocket.getBoardLocation() + 1)) {
                                this.deletePlayer();
                            }
                        }
                    }

                    this.pathArray[rocket.getBoardLocation()] = rocket.getRocketPlayer().getColor();

                }
                stepsHelp++;
            }

        }

    }


    public void reverseArray(Rocket[] array) {
        int left = 0, right = array.length - 1;

        while (left < right) {

            // Scambio
            Rocket temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }


    public Rocket[] orderPlayer() {
        List<Rocket> list = new ArrayList<>();

        for (String s : this.pathArray) {
            if (s != null) { // Evita il blocco vuoto
                for (Rocket r : this.rocketArray) {
                    if (s.equals(r.getRocketPlayer().getColor())) {
                        list.add(r);
                    }
                }
            }
        }

        Rocket[] arrayRockets = (Rocket[]) list.toArray();

        reverseArray(arrayRockets);

        return arrayRockets; // Converte la lista in un array tipizzato
    }

    public boolean isFree(int i) {
        if (pathArray[i] != null) {
            return false;
        }
        return true;
    }

    public boolean checkNumRounds(int index) {
        return true;

    }

    // Metodi getter per accedere ai dati
    public Deck getDeck() {
        return deck;
    }

    public String[] getPathArray() {
        return pathArray;
    }

    public Rocket[] getRocketArray() {
        return rocketArray;
    }

    public void deletePlayer() {

    }

    public void startHourglass() {
        int Iteration = 0;
        if (Iteration >= 2) {
            System.out.println("Game Starts!");
            return;
            //connessione con controller per iniziare il gioco (CONTROLLER)
        }
        if (timerRunning) {
            System.out.println("Timer already running.");
            return;
        }
        System.out.println("Hourglass flipped, 90 seconds ");
        timerRunning = true;
        Iteration++;

        Runnable timerTask = new Runnable() {
            @Override
            public void run() {
                for (int i = 90; i > 0; i--) {
                    System.out.println("Secondo: " + i);
                    try {
                        Thread.sleep(1000); // Aspetta 1 secondo
                    } catch (InterruptedException e) {
                        System.out.println("Il timer è stato interrotto.");
                        return;
                    }
                }
                timerRunning = false;
                System.out.println("La clessidra è finita. Si gira automaticamente di nuovo.");
            }
        ;};
    }
}


