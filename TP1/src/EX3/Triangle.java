import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez la taille du motif : ");
        int length = scanner.nextInt();

        versionA(length);

        System.out.println("\n --- ");

        versionB(length);

    }

    public static void versionA(int length) {
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void versionB(int length) {
        int i = 1;

        while (i <= length) {
            int j = 1;
            while (j <= i) {
                System.out.print("* ");
                j++;
            }

            System.out.println();
            i++;
        }
    }

}
