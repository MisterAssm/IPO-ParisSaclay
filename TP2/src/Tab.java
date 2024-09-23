public class Tab {

    private int start; // inclus
    private int end; // exclue
    private String[] array;

    public Tab(int start, int end) {
        this.start = start;
        this.end = end;

        // si start est positif, retirer 1 (sinon tableau trop grand)
        // si start est négatif, ajouter un (sinon tableau trop petit)
        this.array = new String[start < end ? (end - start + (start < 0 ? 1 : -1)) : 0];
    }

    public static void main(String[] args) {
        Tab tab = new Tab(0, 5);

        System.out.println(tab.length()); // 4
        tab.set(2, "test");
        System.out.println(tab.get(0)); // null
        System.out.println(tab.get(2)); // "test"

        Tab tab1 = new Tab(-2, 2);
        System.out.println(tab1.length()); // 4
        tab1.set(-2, "test 1");
        tab1.set(0, "test 2");
        tab1.set(1, "test 3");
        System.out.println(tab1.get(-2)); // "test 1"
        System.out.println(tab1.get(0)); // "test 2"
        System.out.println(tab1.get(1)); // "test 3"

        Tab tab2 = new Tab(4, 1);
        System.out.println(tab2.length()); // 0
    }

    public int length() {
        return array.length;
    }

    public String get(int i) {
        return array[i - start];
    }

    public void set(int i, String s) {
        array[i - start] = s;
    }
}
