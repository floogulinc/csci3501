# CSCI 3501 Lab 1
### Paul Friederichsen

## Running

To compile and run the project, run:
```
./gradlew run --args="n"
```

Where `n` is the input integer. The program prints combinations of integers 1 to `n` and the time it took to do so in nanoseconds.

Example:

```
PS C:\Users\floogulinc\Documents\Code\Git Repositories\csci3501\lab1> .\gradlew run --args="3"

> Task :run
1 2 3
2 1 3
3 1 2
1 3 2
2 3 1
3 2 1
Done in 28075739 ns

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
```

You can also have it run the permutations multiple times and calculate the average runtime:
```
./gradlew run --args="n t"
```
Where `n` is the input integer and `t` is the number of times to run the program.

Example:
```
PS C:\Users\floogulinc\Documents\Code\Git Repositories\csci3501\lab1> .\gradlew run --args="2 3"

> Task :run
Run 1
1 2
2 1
Run 2
1 2
2 1
Run 3
1 2
2 1
Times:
30479114 ns
61570 ns
60490 ns
Average time for 3 runs of permutations 1 to 2: 1.0200391333333334E7 ns
Average time for last 2 runs: 61570.0 ns

BUILD SUCCESSFUL in 1s
2 actionable tasks: 2 executed
```

## Runtime Calculation

### Efficiency

In terms of printed lines, the program prints 1 line for each permutation and the number of permutations of numbers 1 to n is n! so it should be O(n!).

When `generate(n)` is called with n>1 it makes n recursive calls, one at the beginning and n-1 in the for loop. Each of those calls makes n-1 recursive calls itself and so on until n = 1 where it prints that permutation.

### Timing Results
I looked at the average time for the last 9 runs of 10 for each n to eliminate some of the constant overhead.

| n | Average time (ns) |
|---|---|
| 1 | 32270.125 |
| 2 | 57991.625 |
| 3 | 162565.25 |
| 4 | 522666.375 |
| 5 | 2210025.125 |
| 6 | 1.1008604375E7 |
| 7 | 8.35756735E7 |

Based on these results it looks like the average time is about `n! * [time for one line]`.
To get an average time per line I averaged each `(average time/n!)` for an average per line time of 22918 ns.

So for `n=15` it would take approximately `15!*22918 ns` which is 346.86668 days
 
and for `n=15` it would take approximately `20!*22918 ns` which is 1,766,878.32 years