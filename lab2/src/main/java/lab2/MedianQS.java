package lab2;

import java.util.Random;

/**
 * Quicksort implementation from CSCI 2101 work, refactored to better match the textbook pseudocode.
 * Modified to use a median pivot
 *
 */
public class MedianQS implements Sorter {

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        quicksort(arr);
    }

    private Random rand = new Random();
    
    private int k; //threshold

    public MedianQS(int threshold) {
        this.k = threshold;
    }

    /**
     * The method sorts an array using quicksort sort
     *
     * @param <T>
     *            - the type of elements in the array (must extend
     *            Comparable<T>)
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
     *            Comparable<T>)
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
        
        if((r-p) > k) {
            int a = rand.nextInt((r-p)+1)+p, b = rand.nextInt((r-p)+1)+p, c = rand.nextInt((r-p)+1)+p;

            int median;

            int atob = arr[a].compareTo(arr[b]);

            if(atob == 0) { // a==b
                median = a;
            } else if(atob < 0) { // a<b
                int atoc = arr[a].compareTo(arr[c]);
                if(atoc == 0) { // a==c
                    median = a;
                } else if (atoc < 0) { //a<c
                    int btoc = arr[b].compareTo(arr[c]);
                    if(btoc == 0) { // b==c
                        median = b;
                    } else if (btoc < 0) { // b<c so a<b<c
                        median = b;
                    } else { // b>c so a<c<b
                        median = c;
                    }
                } else { // a>c so c<a<b
                    median = a;
                }
            } else { // a>b
                int atoc = arr[a].compareTo(arr[c]);
                if(atoc == 0) { // a==c
                    median = a;
                } else if (atoc < 0) { //a<c so b<a<c
                    median = a;
                } else { // a>c 
                    int btoc = arr[b].compareTo(arr[c]);
                    if(btoc == 0) { // b==c
                        median = b;
                    } else if (btoc < 0) { // b<c so b<c<a
                        median = c;
                    } else { // b>c so c<b<a
                        median = b;
                    }
                }
            }

            swap(arr, r, median);
        }
        
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
