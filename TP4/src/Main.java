import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        QCM qcm = new QCM(
                new Question("À propos des nombres premiers :",
                        1.0,
                        new Answer("Le nomre 1 est premier", false),
                        new Answer("Il en existe une infinité", true),
                        new Answer("Un nombre pair peut être premier", true),
                        new Answer("Le produit de deux nombres premiers est premier", false)
                ),
                new Question("Quel temps fait-il aujourd'hui ?",
                        0.5,
                        new Answer("Nuageux", true),
                        new Answer("Pluvieux", false),
                        new Answer("Orageux", false)
                )
        );

        System.out.print("Nombre d'utilisateur pour ce QCM : ");
        int n = Utils.enterPositiveInt(10);
        double maxScore = qcm.calculateMaxScore();
        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.println("=== Utilisateur n° " + (i + 1) + " ===");
            scores[i] = qcm.copy().startQCM();
        }

        if (n > 1) {
            System.out.printf("Moyenne des scores : %.2f/%.2f", Arrays.stream(scores).sum() / n, maxScore);
        }
    }
}