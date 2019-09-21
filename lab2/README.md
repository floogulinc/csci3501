# CSCI 3501 Lab 2 and 3
### Paul Friederichsen


MedianQS Optimization:

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

insertion sort quicksort optimization:
```
STATS FOR BEST INDEX FOR 100 RUNS:
Average: 6.46
Min: 6
Max: 7
Count: 100
```

because we resort whole array once finding that it is below threshold, we could use insertion on the parts ot the arrays left unsorted instead maybe.

also testing is only against random arrays right now, not all the options...





From Java `DualPivotQuicksort.class`:
```java
/**
 * If the length of an array to be sorted is less than this
 * constant, Quicksort is used in preference to merge sort.
 */
private static final int QUICKSORT_THRESHOLD = 286;

/**
 * If the length of an array to be sorted is less than this
 * constant, insertion sort is used in preference to Quicksort.
 */
private static final int INSERTION_SORT_THRESHOLD = 47;
```

Some normal runs of
```java
List<Sorter> sorters = List.of(new JavaTimSort(), new QuickSort(), new RandomizedQS(), new MedianQS(20), new InsertionQS(6));
```

Testing on 10,000 random ints 1-1,000,000
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
------------------------------
Testing on the range 1-10000
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
------------------------------
Testing on 10 sequences of ranges of 1000
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
------------------------------
Testing on 100 sequences of ranges 100
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
------------------------------

Testing on 10,000 random ints 1-1,000,000
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
------------------------------
Testing on the range 1-10000
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
------------------------------
Testing on 10 sequences of ranges of 1000
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
------------------------------
Testing on 100 sequences of ranges 100
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
------------------------------