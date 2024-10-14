import java.util.Iterator;

public class TabSet implements Set {

    private int[] tab;
    private int size;

    public TabSet(int capacity) {
        this.tab = new int[capacity];
        this.size = 0;
    }

    @Override
    public boolean contains(int element) {
        for (int value : tab) {
            if (value == element) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int cardinal() {
        return size;
    }

    @Override
    public boolean add(int element) {
        if (!contains(element)) {
            // On s'autorise à échouer si on dépasse la capacité initiale
            tab[size] = element;
            size++;
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(int element) {
        boolean permute = false;

        for (int i = 0; i < size; i++) {
            if (!permute && tab[i] == element) {
                permute = true;
            } else if (permute) {
                tab[i - 1] = tab[i];
            }
        }

        if (permute) {
            size--;
        }

        return permute;
    }

    @Override
    public Set clone() {
        TabSet tabSet = new TabSet(tab.length);

        for (int value : tab) {
            tabSet.add(value);
        }

        return tabSet;
    }

    @Override
    public Set union(Set second) {
        Set unionSet = second.clone();

        for (int element : tab) {
            unionSet.add(element);
        }

        return unionSet;
    }

    @Override
    public Set intersection(Set second) {
        Set intersectionSet = new TabSet(tab.length);

        for (int element : tab) {
            if (second.contains(element)) {
                intersectionSet.add(element);
            }
        }

        return intersectionSet;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(tab[i]);

            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }

        return stringBuilder.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;
        Set set = (Set) o;

        for (int element : tab) {
            if (!set.contains(element)) return false;
        }

        return cardinal() == set.cardinal();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new TabSetIterator(tab, size);
    }
}
