import java.util.ArrayList;

public class Agenda {
    
    private ArrayList<Intervalle> intervalleList;

    public Agenda() {
        this.intervalleList = new ArrayList<>();
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.insertion(new Intervalle(new Chrono(1, 0, 0), new Chrono(2, 0, 0)));
        agenda.insertion(new Intervalle(new Chrono(3, 0, 0), new Chrono(5, 0, 0)));
        agenda.insertion(new Intervalle(new Chrono(2, 30, 0), new Chrono(4, 0, 0))); // impossible

        System.out.println(agenda);
    }

    public String toString() {
        String result = "Activitées de l'agenda :\n";

        for (Intervalle intervalle : intervalleList) {
            result += "Activité " + intervalle + "\n";
        }

        return result;
    }

    public boolean compatible(Intervalle intervalle) {
        for (Intervalle i : intervalleList) {
            if (intervalle.conflit(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean insertion(Intervalle intervalle)  {
        if (compatible(intervalle)) {
            return intervalleList.add(intervalle);
        }

        return false;
    }

}
