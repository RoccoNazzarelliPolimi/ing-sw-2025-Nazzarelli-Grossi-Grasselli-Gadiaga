
    public class Cargo {
        private Storage storage; // Magazzino in cui si trova il cargo
        private int value;       // Valore del carico

        // Costruttore
        public Cargo(Storage storage, int value) {
            this.storage = storage;
            this.value = value;
        }

        // Getter per il valore del cargo
        public int getValue() {
            return value;

        }

    }




