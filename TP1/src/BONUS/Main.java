import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre n (ex. 155) : ");

        int n = scanner.nextInt();
        List<Integer> decomposition = decomp3cubes(n);

        if (decomposition.isEmpty()) {
            System.out.println("Pas de décomposition possible pour " + n);
        } else {
            System.out.printf("%d = %d³ + %d³ + %d³", n, decomposition.get(0), decomposition.get(1), decomposition.get(2));
        }
    }


    // Question b
    public static boolean checkIfCubed(int n) {
        double a = Math.pow(n, 1.0 / 3.0);
        return n == Math.pow(a, 3);
    }

    public static List<Integer> decomp3cubes(int n) {

        int c1 = (int) Math.floor(Math.cbrt(n));

        while (c1 > 0) {
            int nb = (int) (n - Math.pow(c1, 3));
            int c2 = (int) Math.floor(Math.cbrt(nb));

            if (c1 < c2) {
                c1 = 0;
                c2 = 0;
            }

            while (c2 > 0) {
                int nb2 = (int) (nb - Math.pow(c2, 3));
                int c3 = (int) Math.floor(Math.cbrt(nb2));

                if (c2 < c3) {
                    c2 = 0;
                    nb2 = 0;
                }

                if (nb2 != 0 && checkIfCubed(nb2)) {
                    return new ArrayList<>(Arrays.asList(c1, c2, c3));
                }

                c2--;
            }

            c1--;
        }

        return new ArrayList<>();
    }

}
