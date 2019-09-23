package lab2;

/**
 * A wrapper around an integer that counts how many comparisons occur
 */
public final class TestInteger implements Comparable<TestInteger> {

    private final int value;

    private static long counter = 0;

    /**
     * Gets the value of the global comparisons counter
     * @return the {@code long} value of the counter
     */
    public static long getCounter() {
        return counter;
    }

    /**
     * Resets the global comparisons counter
     */
    public static void resetCounter() {
        counter = 0;
    }

    /**
     * Creates a new TestInteger with the given value
     * @param value the {@code int} value for the new TestInteger
     */
    public TestInteger(int value) {
        this.value = value;
    }

    /**
     * The value of the integer
     * @return The {@code int} value of the TestInteger
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Compares this object to another TestInteger using {@link Integer#compare} 
     * and increases the global counter by one
     * @param o The TestInteger to compare to
     */
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
