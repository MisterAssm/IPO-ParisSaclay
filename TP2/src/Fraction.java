public class Fraction {

    private int numerateur;
    private int denominateur;

    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;

        this.simplify();
    }

    public static void main(String[] args) {
        Fraction x = new Fraction(54, 162);
        Fraction y = new Fraction(2, 3);
        Fraction z = new Fraction(2, 1);
        Fraction alpha = new Fraction(3, 4);
        Fraction beta = new Fraction(2, 9);

        System.out.println(x); // "1/3"
        System.out.println(y); // "2/3"
        System.out.println(z); // "2"

        System.out.println("\n-----\n");
        System.out.println(x.add(alpha)); // 13/12
        System.out.println(x.add(beta)); // 5/9

        System.out.println("\n-----\n");
        System.out.println(x.mul(alpha)); // 1/4
        System.out.println(x.mul(beta)); // 2/27

        System.out.println("\n-----\n");
        System.out.println(x.egale(y)); // false
        System.out.println(x.egale(new Fraction(1, 3))); // true

        System.out.println("\n-----\n");
        System.out.println(x.compareTo(y)); // plus petit
        System.out.println(x.compareTo(new Fraction(1, 3))); // égal
        System.out.println(x.compareTo(new Fraction(-2, 3))); // plus grand
    }

    private static int pgcd(int a, int b) {
        int pgcd = 0;

        // Ou utiliser Math#abs
        if (a < 0) {
            a = -a;
        }

        if (b < 0) {
            b = -b;
        }

        // pour i allant de 1 à min(a,b) inclus
        for (int i = 1; i <= a && i <= b; i++) {
            // si i est divisible par a et b
            if (a % i == 0 && b % i == 0) {
                pgcd = i;
            }
        }

        return pgcd;
    }

    private void simplify() {
        int currentPgcd = pgcd(numerateur, denominateur);

        while (currentPgcd > 1) {
            numerateur /= currentPgcd;
            denominateur /= currentPgcd;

            currentPgcd = pgcd(numerateur, denominateur);
        }
    }

    public Fraction add(Fraction fraction) {
        Fraction result;

        if (denominateur == fraction.getDenominateur()) {
            result = new Fraction(numerateur + fraction.getNumerateur(), denominateur);
        } else {
            result = new Fraction((numerateur * fraction.getDenominateur()) + (fraction.getNumerateur() * denominateur), denominateur * fraction.getDenominateur());
        }

        result.simplify();

        return result;
    }

    public Fraction mul(Fraction fraction) {
        Fraction result = new Fraction(numerateur * fraction.getNumerateur(), denominateur * fraction.getDenominateur());

        result.simplify();

        return result;
    }

    public String toString() {
        return numerateur + (denominateur == 1 ? "" : "/" + denominateur);
    }

    public boolean egale(Fraction fraction) {
        return numerateur == fraction.getNumerateur() && denominateur == fraction.getDenominateur();
    }

    public int compareTo(Fraction fraction) {
        return this.add(fraction.mul(new Fraction(-1, 1))).numerateur;
    }

    public int getNumerateur() {
        return numerateur;
    }

    public int getDenominateur() {
        return denominateur;
    }
}
