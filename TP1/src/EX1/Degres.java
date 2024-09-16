import java.util.Scanner;

public class Degres {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez une température en Fahrenheit : ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (5 * (fahrenheit - 32)) / 9;

        System.out.println("Cette température équivaut à " + String.format("%.1f", celsius) + " degrés Celsius");
    }

}
