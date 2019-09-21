package lab2;

@FunctionalInterface
public interface Sorter {
    public <T extends Comparable<T>> void sort(T[] arr);
}