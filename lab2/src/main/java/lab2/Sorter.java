package lab2;
/**
 * Defines a sorter, which has a {@link #sort} method
 */
@FunctionalInterface
public interface Sorter {
    /**
     * Sorts the given array
     * @param <T> The class of the items in the array, must implement {@link Comparable}
     * @param arr The array to sort
     */
    public <T extends Comparable<T>> void sort(T[] arr);
}