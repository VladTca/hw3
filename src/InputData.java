import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public record InputData(int tarakans, int rounds) {

    public static InputData getInputData() {
        int tarakans = 0;
        int rounds = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Enter number of Tarakans:");
                String line1 = br.readLine();
                System.out.println("Enter number of rounds:");
                String line2 = br.readLine();
                if (line1.matches("\\d+") && line2.matches("\\d+")
                        && Integer.parseInt(line1) > 1 && Integer.parseInt(line2) > 0) {
                    tarakans = Integer.parseInt(line1);
                    rounds = Integer.parseInt(line2);
                   break;
                } else {
                    System.out.println("Error in input");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new InputData(tarakans, rounds);
    }
}
