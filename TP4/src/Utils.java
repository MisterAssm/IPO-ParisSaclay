import java.util.InputMismatchException;
import java.util.Scanner;

public class Utils {

    /**
     * wait for the user to enter an integer between 0 and max or enter nothing
     *
     * @param max
     * @return the integer or -1 if pass
     */
    public static int enterPositiveIntOrPass(int max) {
        return enterPositiveIntOrPass(false, max);
    }

    public static int enterPositiveIntOrPass(boolean strict, int max) {
        Scanner scanner = new Scanner(System.in);
        try {
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                return -1;
            }

            int value = Integer.parseInt(input);

            if (value < (strict ? 1 : 0) || value > max) {
                System.out.println("Entrée invalide, recommencez : ");
                return enterPositiveIntOrPass(max);
            }

            return value;
        } catch (InputMismatchException | NumberFormatException ignored) {
            System.out.println("Entrée invalide, recommencez : ");
            return enterPositiveIntOrPass(max);
        }
    }

    /**
     * wait for the user to enter an integer between 0 and max
     * @param max
     * @return the integer
     */
    public static int enterPositiveInt(int max) {
        Scanner sc = new Scanner(System.in);
        int a;
        try {
            a = sc.nextInt();
            if (a < 0 || a > max) {
                System.out.print("Entrée invalide, recommencez : ");
                return enterPositiveInt(max);
            }
            return a;
        } catch (InputMismatchException e) {
            System.out.print("Entrée invalide, recommencez : ");
            return enterPositiveInt(max);
        }

    }
}