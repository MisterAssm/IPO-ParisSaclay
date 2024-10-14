import java.util.Iterator;

public class TabSetIterator implements Iterator<Integer> {

    private final int[] tab;
    private final int size;
    private int index;

    public TabSetIterator(int[] tab, int size) {
        this.tab = tab;
        this.size = size;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Integer next() {
        return tab[index++];
    }
}
