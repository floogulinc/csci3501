# CSCI 3501 Lab 2 and 3
### Paul Friederichsen


## Running

The source files are in `src/main/java/lab2`

To compile and run the project, run:
```
./gradlew run
```

To generate Javadocs, run:
```
./gradlew javadoc
```
That will put them in `build/docs/javadoc`

## Analysis

### QuickSort

Between TimSort and QuickSort, TimSort does fewer comparisons for all tests. The difference isn't too much for completely random data, with TimSort being about 20% better. For the tests on completely sorted or partially sorted data though, the difference is much greater. For a completely sorted array, TimSort does 5000 times fewer comparisons than QuickSort.

### RandomizedQS

QuickSort with random pivots seems to have slightly better comparison performance to regular QuickSort on average for completely random data. For fully and partially pre-sorted data though, it performs much better than regular QuickSort. It still does more comparisons than TimSort in all the tested cases.

The greatly increased performance in pre-sorted arrays is due to how regular QuickSort has to swap every element all the way along the array for every element and the random pivot prevents this.

### MedianQS

QuickSort with pivots chosen by the median of three random items in the array (until there are few enough items in the sub-array, 20 in this case) performs notably better than regular QuickSort and RandomizedQS for random values. For the other tests of partially or completely sorted data, it performs worse than RandomizedQS and TimSort but still better than QuickSort.

MedianQS achieves better performance in random items than RandomizedQS because taking the median of three random array items means most of the time the pivot is closer to a optimal split.

The reason for decent performance in sorted data is similar to RandomizedQS.

### InsertionQS

QuickSort that uses insertion sort when it gets to small enough sub-arrays performs worse than all other algorithms in completely random integers. The same applies to partially and completely pre-sorted arrays.

This bad performance is due to the fact that, even with the best performing threshold of 6, it still is going through the entire partially-sorted array with insertion sort instead of just portions of it, which is fairly inefficient to traverse.

While my implementation followed the instructions of the lab:

> **Switching to insertion sort at the end:** when the array is nearly sorted, stop the quicksort without finishing the sorting, and then use insertion sort on the entire array to finish the process. 

There are other ways to use insertion sort in quicksort that are probably better. Namely, using insertion sort to sort each subarray when it's small enough instead of returning out and using it to sort the entire array. 

## Run Data

Some normal runs using these sorters:

```java
List<Sorter> sorters = List.of(new JavaTimSort(), new QuickSort(), new RandomizedQS(), new MedianQS(20), new InsertionQS(6));
```

### Run 1

#### Testing on 10,000 random ints 1-1,000,000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 120488      | 151845    | 151101        | 137300   | 158505      |      
| 120461      | 156842    | 156276        | 137345   | 163645      |      
| 120484      | 151024    | 153507        | 135174   | 157656      |      
| 120365      | 153539    | 153600        | 137057   | 160028      |      
| 120312      | 159254    | 144820        | 133621   | 165943      |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 120422.0    | 154500.8  | 151860.8      | 136099.4 | 161155.4    |      


#### Testing on the range 1-10000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 9999        | 49995000  | 160035        | 180930   | 50004978    |      
| 9999        | 49995000  | 155018        | 177980   | 50004978    |      
| 9999        | 49995000  | 154896        | 175830   | 50004978    |      
| 9999        | 49995000  | 143756        | 176254   | 50004978    |      
| 9999        | 49995000  | 150178        | 175535   | 50004978    |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 9999.0      | 4.9995E7  | 152776.6      | 177305.8 | 5.0004978E7 |      


#### Testing on 10 sequences of ranges of 1000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 10221       | 23000000  | 163125        | 167025   | 23009915    |      
| 10288       | 26004000  | 165084        | 170242   | 26013894    |      
| 10297       | 15010000  | 152184        | 168749   | 15019852    |      
| 10233       | 12009000  | 150484        | 163514   | 12018852    |      
| 10312       | 12015000  | 155611        | 172411   | 12024852    |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 10270.2     | 1.76076E7 | 157297.6      | 168388.2 | 1.7617473E7 |      


#### Testing on 100 sequences of ranges 100:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 14256       | 2625900   | 150477        | 159713   | 2634828     |      
| 14295       | 3362400   | 163752        | 158983   | 3371412     |      
| 14302       | 4348500   | 156496        | 162760   | 4357407     |      
| 14426       | 4275900   | 152479        | 163403   | 4284891     |      
| 14464       | 2949000   | 151108        | 154696   | 2957844     |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 14348.6     | 3512340.0 | 154862.4      | 159911.0 | 3521276.4   |      


### Run 2

#### Testing on 10,000 random ints 1-1,000,000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 120413      | 181838    | 154262        | 134856   | 188535      |      
| 120429      | 168297    | 164003        | 134512   | 175046      |      
| 120306      | 148381    | 163945        | 145420   | 155150      |      
| 120359      | 157028    | 166231        | 140868   | 163906      |      
| 120382      | 149673    | 148008        | 136507   | 156355      |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 120377.8    | 161043.4  | 159289.8      | 138432.6 | 167798.4    |      


#### Testing on the range 1-10000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 9999        | 49995000  | 154929        | 176420   | 50004978    |      
| 9999        | 49995000  | 149641        | 177121   | 50004978    |      
| 9999        | 49995000  | 146388        | 172005   | 50004978    |      
| 9999        | 49995000  | 148298        | 172915   | 50004978    |      
| 9999        | 49995000  | 153065        | 171754   | 50004978    |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 9999.0      | 4.9995E7  | 150464.2      | 174043.0 | 5.0004978E7 |      


#### Testing on 10 sequences of ranges of 1000:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS  |     
| ----------- | --------- | ------------- | -------- | ------------ |     
| 10324       | 21002000  | 159005        | 167428   | 21011915     |     
| 10342       | 16006000  | 146177        | 170136   | 16015894     |     
| 10258       | 18002000  | 155821        | 170586   | 18011915     |     
| 10328       | 11011000  | 147740        | 173750   | 11020873     |     
| 10379       | 16006000  | 153918        | 168521   | 16015894     |     
|             |           |               |          |              |     
|             |           |  **Average**  |          |              |     
| 10326.2     | 1.64054E7 | 152532.2      | 170084.2 | 1.64152982E7 |     


#### Testing on 100 sequences of ranges 100:

| JavaTimSort | QuickSort | RandomizedQS  | MedianQS | InsertionQS |      
| ----------- | --------- | ------------- | -------- | ----------- |      
| 14556       | 3874200   | 154407        | 158892   | 3883065     |      
| 14433       | 3393500   | 157461        | 160669   | 3402512     |      
| 14317       | 3277900   | 155743        | 156929   | 3286912     |      
| 14229       | 3861900   | 154460        | 158565   | 3870786     |      
| 14375       | 4276400   | 145017        | 161764   | 4285391     |      
|             |           |               |          |             |      
|             |           |  **Average**  |          |             |      
| 14382.0     | 3736780.0 | 153417.6      | 159363.8 | 3745733.2   |      

## Optimizing  

To optimize each of the last 2 types of sorters (median pivot and insertion sort for small arrays), I setup some tests against the random array sorting test where it sorts 10 random arrays for each value of k (threshold for using regular pivot or using insertion sort) 1 to 100 (any higher was definitely worse). It gets the average runtime of the 10 runs for each of the values of k and shows the average, best, and worst time with the actual k value for the min and max. I ran that entire test 100 times to find the average k value of the min times.

### MedianQS Optimization

To run the test yourself (it will only run 10 times to save time, you can set the number of times in the code), run 
```
./gradlew run --args="testmedian"
```

Results of a couple of runs of 100 each:

```
STATS FOR BEST INDEX FOR 100 RUNS:
Average: 21.8
Min: 7
Max: 74
Count: 100
```

```
STATS FOR BEST INDEX FOR 100 RUNS:
Average: 21.87
Min: 8
Max: 68
Count: 100
```

Based on these results I left the setting for k as 20 for general tests.

### InsertionQS Optimization

To run the test yourself (it will only run 10 times to save time, you can set the number of times in the code), run 
```
./gradlew run --args="testinsert"
```

Results for a run of 100:

```
STATS FOR BEST INDEX FOR 100 RUNS:
Average: 6.46
Min: 6
Max: 7
Count: 100
```

Based on these results I set k to 6 for general tests.

This is interesting when compared to the threshold used in Java's built in quicksort.

From the JDK 11 `DualPivotQuicksort.class`:
```java
/**
 * If the length of an array to be sorted is less than this
 * constant, insertion sort is used in preference to Quicksort.
 */
private static final int INSERTION_SORT_THRESHOLD = 47;
```