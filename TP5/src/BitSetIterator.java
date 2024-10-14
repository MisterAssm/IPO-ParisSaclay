import java.util.Iterator;

public class BitSetIterator implements Iterator<Integer> {
    private boolean[] bits;
    private int cardinal;
    private int current;
    private int n;

    public BitSetIterator(boolean[] bits, int cardinal) {
        this.bits = bits;
        this.cardinal = cardinal;
        this.current = 0;
        this.n = 0;
    }

    @Override
    public boolean hasNext() {
        return n < cardinal;
    }

    @Override
    public Integer next() {
        if (bits[current]) {
            n++;
            return current++;
        }

        current++;
        return next();
    }
}
