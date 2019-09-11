package lab2;

public final class TestInteger implements Comparable<TestInteger> {

    private final int value;

    private static long counter = 0;

    public static long getCounter() {
        return counter;
    }

    public static void resetCounter() {
        counter = 0;
    }

    public TestInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    @Override
    public int compareTo(TestInteger o) {
        counter++;
        return Integer.compare(this.getValue(), o.getValue());
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

}
