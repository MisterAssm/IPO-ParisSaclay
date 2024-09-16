// Exemples d'utilisation des fonctions de saisie, pour rÃ©cupÃ©rer des valeurs
// donnÃ©es au clavier par l'utilisateur.

// Ã‰tape 1.
// Directive Ã  placer au dÃ©but du fichier pour permettre l'utilisation de
// ces fonctions.
import java.util.Scanner;

public class ScannerDemo {
  
    public static void main(String[] args){

        // Ã‰tape 2.
        // Initialisation.
        Scanner sc = new Scanner(System.in);

        // Maintenant, c'est prÃªt Ã  utiliser !
        //   sc.next()         lit une chaÃ®ne de caractÃ¨res
        //   sc.nextInt()      lit un entier
        //   sc.nextDouble()   lit un nombre dÃ©cimal
        // (il en existe encore d'autres)
        System.out.print("Entrez votre nom : ");
        String s = sc.next();

        System.out.print("Entrez votre Ã¢ge : ");
        int i = sc.nextInt();

        System.out.print("Entrez votre taille : ");
        double d = sc.nextDouble();

        System.out.println("RÃ©sumÃ© pour " + s + " : ");
        System.out.println("  - Ã¢ge " + i);
        System.out.println("  - taille " + d);
   }
}