import java.util.Scanner;

public class Pyramide {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez la taille du motif : ");
        int length = scanner.nextInt();

        for (int line = 0; line < length; line++) {
            for (int i = line + 1; i < length; i++) {
                System.out.print("  ");
            }

            for (int i = 0; i < (line * 2 + 1); i++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

}
