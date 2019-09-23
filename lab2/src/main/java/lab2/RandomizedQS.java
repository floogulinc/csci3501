package lab2;

import java.util.Random;

/**
 * Quicksort implementation from CSCI 2101 work, refactored to better match the textbook pseudocode.
 * Modified to use random pivot
 *
 */
public class RandomizedQS implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        quicksort(arr);
    }

    private Random rand = new Random();    

    /**
     * The method sorts an array using quicksort sort
     *
     * @param <T>
     *            - the type of elements in the array (must extend
     *            Comparable)
     * @param arr
     *            - the array to be sorted
     */
    public <T extends Comparable<T>> void quicksort(T[] arr) {
        if (arr == null || arr.length <= 1) return;
        quicksort(arr, 0, arr.length - 1);
    }

    /**
     * The method sorts a portion of the array between two given indices using
     * quicksort algorithm. The method is recursive.
     *
     * @param <T>
     *            - the type of elements in the array (must extend
     *            Comparable)
     * @param arr
     *            - the array to be sorted
     * @param begin
     *            - index of the first element of the portion to sort
     * @param end
     *            - index of the last element of the portion to sort
     */
    private <T extends Comparable<T>> void quicksort(T[] arr, int begin, int end) {
        if (begin > end) return;
        int q = partition(arr, begin, end);
        quicksort(arr, begin, q - 1);
        quicksort(arr, q + 1, end);
    }

    private <T extends Comparable<T>> int partition(T[] arr, int p, int r) {
        swap(arr, r, rand.nextInt((r-p)+1)+p);
        T pivot = arr[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, r);
        return i + 1;
    }

    /**
     * Swap the values at two indices in an array
     *
     * @param arr
     *            - the array
     * @param i
     *            - the first index
     * @param j
     *            - the second index
     */
    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
