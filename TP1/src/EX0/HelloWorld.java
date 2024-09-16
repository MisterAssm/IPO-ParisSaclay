import java.util.Scanner;

// Le programme doit porter le mÃªme nom que le fichier
// Ici, le fichier s'appelle HelloWorld.java
public class HelloWorld {

    // Fonction principale, appelÃ©e par le programme
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez votre nom : ");
        String name = sc.next();

        // DÃ©clarations de variables
        int num = 9;
        String month = "septembre";

        // System.out.println affiche sur la sortie standard
        System.out.println("Hello world!");

        // + peut servir a concatÃ©ner des chaines de caractÃ¨res
        System.out.println("Hello " + name + "!");

        // Une conversion d'un nombre en chaÃ®ne de caractÃ¨res se fait
        // "automatiquement" (Ã  venir dans le cours : via toString() )
        System.out.println("Nous sommes le " + num + " " + month);

    }
}