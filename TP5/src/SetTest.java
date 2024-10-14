import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {

    static Stream<Set> setStream() {
        Set tabSet = new TabSet(10);
        Set bitSet = new BitSet(10);

        IntStream.rangeClosed(1, 5).forEach(value -> {
            tabSet.add(value);
            bitSet.add(value);
        });

        return Stream.of(tabSet, bitSet);
    }

    static Stream<Arguments> multipleSetStream() {
        Set tabSet = new TabSet(10);
        Set secondTabSet = new TabSet(10);
        Set bitSet = new BitSet(10);
        Set secondBitSet = new BitSet(10);

        IntStream.rangeClosed(1, 5).forEach(value -> {
            tabSet.add(value);
            bitSet.add(value);
        });

        IntStream.rangeClosed(3, 6).forEach(value -> {
            secondTabSet.add(value);
            secondBitSet.add(value);
        });

        return Stream.of(Arguments.of(tabSet, secondTabSet), Arguments.of(bitSet, secondBitSet));
    }

    @ParameterizedTest
    @MethodSource("setStream")
    void contains(Set set) {
        assertFalse(set.contains(6));
        set.add(6);
        assertTrue(set.contains(6));
    }

    @ParameterizedTest
    @MethodSource("setStream")
    void cardinal(Set set) {
        assertEquals(5, set.cardinal());
    }

    @ParameterizedTest
    @MethodSource("setStream")
    void testToString(Set set) {
        assertEquals("[1, 2, 3, 4, 5]", set.toString());
    }

    @ParameterizedTest
    @MethodSource("setStream")
    void remove(Set set) {
        set.remove(3);
        assertEquals("[1, 2, 4, 5]", set.toString());
    }

    @ParameterizedTest
    @MethodSource("setStream")
    void testClone(Set set) {
        Set copy = set.clone();

        copy.remove(3);
        assertEquals(5, set.cardinal());
        assertEquals(4, copy.cardinal());
    }

    @ParameterizedTest
    @MethodSource("multipleSetStream")
    void union(Set set, Set secondSet) {
        Set unionSet = set.union(secondSet);

        System.out.println(unionSet);
        assertEquals(6, unionSet.cardinal());
        IntStream.rangeClosed(1, 6).forEach(value -> assertTrue(unionSet.contains(value)));
    }

    @ParameterizedTest
    @MethodSource("multipleSetStream")
    void intersection(Set set, Set secondSet) {
        Set intersectionSet = set.intersection(secondSet);

        assertEquals("[3, 4, 5]", intersectionSet.toString());
    }
}