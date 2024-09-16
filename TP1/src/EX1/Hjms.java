import java.util.Scanner;

public class Hjms {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Donnez une durée en secondes : ");

        int seconds = scanner.nextInt();
        int minutes = seconds / 60;
        seconds %= 60;
        int hours = minutes / 60;
        minutes %= 60;
        int days = hours / 24;
        hours %= 24;

        System.out.println("Cette durée équivaut à " +
                formatPlural(days, "jour") +
                formatPlural(hours, "heure") +
                formatPlural(minutes, "minute") +
                formatPlural(seconds, "seconde"));
    }

    private static String formatPlural(int value, String type) {
        return value + " " + type + (value > 1 ? "s" : "") + " ";
    }

}
