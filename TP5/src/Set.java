public interface Set extends Iterable<Integer> {

    boolean contains(int element);

    int cardinal();

    String toString();

    boolean add(int element);

    boolean remove(int element);

    Set clone();

    Set union(Set second);

    Set intersection(Set second);

}
