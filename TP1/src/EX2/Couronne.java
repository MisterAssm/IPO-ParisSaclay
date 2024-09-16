import java.util.Scanner;

public class Couronne {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Rayon extérieur : ");
        int rext = scanner.nextInt();

        System.out.print("Rayon intérieur : ");
        int rint = scanner.nextInt();

        System.out.print("Donnez un point x : ");
        int x = scanner.nextInt();
        System.out.print("Donnez un point y : ");
        int y = scanner.nextInt();

        int length = x*x + y*y; // Ou utiliser Math.sqrt

        // (x,y) est dans la couronne ssi est supérieur à rint et inférieur à rext
        if (length >= rint*rint && length <= rext*rext) { // sans valeur au carrée si sqrt
            System.out.println("Ce point est dans la couronne.");
        } else {
            System.out.println("Ce point n'est pas dans la couronne.");
        }

    }

}
