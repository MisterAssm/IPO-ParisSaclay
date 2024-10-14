import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Set tabSet = new TabSet(10);
        Set bitSet = new BitSet(10);

        IntStream.rangeClosed(1, 5).forEach(value -> {
            tabSet.add(value);
            bitSet.add(value);
        });

        tabSet.forEach(System.out::println);
        System.out.println("=== === ===");
        bitSet.forEach(System.out::println);
    }
}