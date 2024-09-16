import java.util.Scanner;

public class TroisNombres {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("1er nombre : ");
        int a = scanner.nextInt();

        System.out.print("2e nombre : ");
        int b = scanner.nextInt();

        System.out.print("3e nombre : ");
        int c = scanner.nextInt();

        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        if (a > c) {
            int temp = a;
            a = c;
            c = temp;
        }

        // Maintenant, a est forcément le plus petit

        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
        }

        System.out.println("Les nombres dans l'ordre croissant : " + a + " " + b + " " + c);

    }

}
