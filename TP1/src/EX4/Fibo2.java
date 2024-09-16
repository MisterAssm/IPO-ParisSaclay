import java.util.Scanner;

public class Fibo2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez une valeur limite : ");
        int limit = scanner.nextInt();

        int u0 = 0;
        int u1 = 1;
        int i = 1;

        while (u1 <= limit) {
            int un = u1 + u0;

            u0 = u1;
            u1 = un;
            i++;
        }
        
        System.out.println("Le premier terme de la suite supérieur à " + limit + " est : " + u1 + " (rang " + i + ")");
    }

}
