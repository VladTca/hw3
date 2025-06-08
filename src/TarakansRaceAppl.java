public class TarakansRaceAppl {
    public static void main(String[] args) {
        InputData data = InputData.getInputData();
        Thread[] threads = new Thread[data.tarakans()];
        for (int i = 0; i < data.tarakans(); i++) {
            threads[i] = new Tarakan(i, data.rounds());
            threads[i].start();
        }

        for (int i = 0; i < data.tarakans(); i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Error" + e.getMessage());
            }
        }

        System.out.println("Race finished!");
        System.out.println("Congratulations to tarakan #" + (Tarakan.getWinner() + 1) + " (winner)");

    }
}
