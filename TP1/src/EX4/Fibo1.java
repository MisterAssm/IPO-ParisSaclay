import java.util.Scanner;

public class Fibo1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez le n-ième terme à calculer : ");
        int n = scanner.nextInt();

        int result;

        if (n <= 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else {
            int u0 = 0;
            int u1 = 1;

            for (int i = 2; i <= n; i++) {
                int un = u1 + u0;

                u0 = u1;
                u1 = un;
            }

            result = u1;
        }

        System.out.println("Le " + n + "e terme de la suite est : " + result);
    }

}
