public class Intervalle {

    private Chrono start;
    private Chrono end;

    public Intervalle(Chrono start, Chrono end) {
        if (end.avant(start)) {
            this.start = new Chrono(0, 0, 0);
            this.end = new Chrono(0, 0, 0);
        } else {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Intervalle intervalle0 = new Intervalle(new Chrono(1, 42, 34), new Chrono(0, 13, 29));
        Intervalle intervalle = new Intervalle(new Chrono(0, 13, 29), new Chrono(1, 42, 34));
        Intervalle intervalle1 = new Intervalle(new Chrono(1, 41, 28), new Chrono(3, 37, 0));

        System.out.println(intervalle0);
        System.out.println(intervalle);
        System.out.println(intervalle1);

        System.out.println("\n ----- \n");
        System.out.println(intervalle.avant(intervalle1));
        System.out.println(intervalle1.avant(intervalle));
        
        System.out.println("\n ----- \n");
        System.out.println(intervalle.conflit(intervalle1));
    }

    public String toString() {
        return "de " + start + " à " + end;
    }

    public Chrono duree() {
        return start.diff(end);
    }

    public boolean avant(Intervalle intervalle) {
        return duree().avant(intervalle.duree());
    }

    public boolean conflit(Intervalle intervalle) {
        return start.avant(intervalle.end);
    }
    
}
