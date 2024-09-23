public class Chrono {

    private int hours;
    private int minutes;
    private int seconds;

    public Chrono(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;

        normalise();
    }

    public static void main(String[] args) {
        Chrono chrono = new Chrono(2, 14, 20);
        Chrono chrono1 = new Chrono(1, 9, 57);

        System.out.println(chrono);
        System.out.println(chrono1);

        System.out.println("\n ----- \n");
        System.out.println(chrono.toSeconds());
        System.out.println(chrono1.toSeconds());

        System.out.println("\n ----- \n");
        System.out.println(new Chrono(3, 651, 1325)); // 14h 13m 5s

        System.out.println("\n ----- \n");
        System.out.println(chrono.equals(chrono1)); // false
        System.out.println(chrono.equals(new Chrono(1, 14, 20))); // true

        System.out.println("\n ----- \n");
        System.out.println(chrono.avant(chrono1)); // false
        System.out.println(chrono1.avant(chrono)); // true

        System.out.println("\n ----- \n");
        System.out.println(chrono.diff(chrono1));
        System.out.println(chrono1.diff(chrono));
    }

    public String toString() {
        return String.format("%dh %dm %ds", hours, minutes, seconds);
    }

    public int toSeconds() {
        return (hours * 60 * 60) + (minutes * 60) + seconds;
    }

    public void normalise() {
        minutes += seconds / 60;
        hours += minutes / 60;

        seconds %= 60;
        minutes %= 60;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Chrono) {
            Chrono chrono = (Chrono) obj;

            return seconds == chrono.seconds && minutes == chrono.minutes && hours == chrono.hours;
        }

        return false;
    }

    public boolean avant(Chrono chrono) {
        if (this.hours < chrono.hours) {
            return true;
        } else if (this.hours > chrono.hours) {
            return false;
        }

        if (this.minutes < chrono.minutes) {
            return true;
        } else if (this.minutes > chrono.minutes) {
            return false;
        }

        return this.seconds < chrono.seconds;
    }

    public void avance(int n) {
        seconds += n;
        normalise();
    }

    public Chrono diff(Chrono chrono) {
        boolean avant = this.avant(chrono);
        Chrono big, little;

        if (avant) {
            big = chrono;
            little = this;
        } else {
            big = this;
            little = chrono;
        }

        return new Chrono(0, 0, big.toSeconds() - little.toSeconds());
    }
}
