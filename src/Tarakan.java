public class Tarakan extends Thread {
    private final int count;
    private final int rounds;
    volatile static int winner = -1;

    public Tarakan(int count, int amount) {
        this.count = count;
        this.rounds = amount;
    }

    @Override
    public void run() {
        for (int i = 0; i < rounds; i++) {
            System.out.println("Tarakan" + " " + (count + 1));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("Error: " + e.getMessage());
            }

        }

        if (winner == -1) {
            synchronized (Tarakan.class) {
                if (winner == -1) {
                    winner = count;
                }
            }
        }
    }

    public static int getWinner() {
        return winner;
    }

}
