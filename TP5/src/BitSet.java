import java.util.Iterator;

public class BitSet implements Set {

    private boolean[] bits;
    private int capacity;

    public BitSet(int capacity) {
        this.bits = new boolean[capacity];
        this.capacity = capacity;
    }

    @Override
    public boolean contains(int element) {
        return capacity >= element && bits[element];
    }

    @Override
    public int cardinal() {
        int n = 0;

        for (boolean bit : bits) {
            if (bit) n++;
        }

        return n;
    }

    @Override
    public boolean add(int element) {
        return bits[element] = true;
    }

    @Override
    public boolean remove(int element) {
        if (capacity >= element) {
            bits[element] = false;
            return true;
        }

        return false;
    }

    @Override
    public Set clone() {
        Set copy = new BitSet(capacity);

        for (int i = 0; i < capacity; i++) {
            if (bits[i]) copy.add(i);
        }

        return copy;
    }

    @Override
    public Set union(Set second) {
        Set unionSet = second.clone();

        for (int i = 0; i < capacity; i++) {
            if (bits[i]) unionSet.add(i);
        }

        return unionSet;
    }

    @Override
    public Set intersection(Set second) {
        Set intersectionSet = new BitSet(capacity);

        for (int i = 0; i < capacity; i++) {
            if (bits[i] && second.contains(i)) intersectionSet.add(i);
        }

        return intersectionSet;
    }

    @Override
    public String toString() {
        int remaining = cardinal();
        StringBuilder stringBuilder = new StringBuilder("[");

        for (int i = 0; i < capacity && remaining > 0; i++) {
            if (bits[i]) {
                stringBuilder.append(i);

                if (--remaining != 0) {
                    stringBuilder.append(", ");
                }
            }
        };

        return stringBuilder.append("]").toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Set)) return false;
        Set set = (Set) o;

        for (int i = 0; i < bits.length; i++) {
            if (!set.contains(i)) return false;
        }

        return cardinal() == set.cardinal();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BitSetIterator(bits, cardinal());
    }
}
