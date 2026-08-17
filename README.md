# Sorting Algorithms Lab

A small Java project that implements and benchmarks classic sorting algorithms.
It has two parts:

1. **Custom sort demo** (`Main`, `Insertion`, `Merge`, `Quick`, `Shuffle`, `Car`) —
   hand-written Insertion, Merge and Quick sort implementations, exercised on a
   shuffled integer array and on an array of `Car` objects sorted by a chosen attribute.
2. **Sorting algorithm benchmark** (`SortingAlgorithmTester`, `SortingAlgorithms`) —
   times Merge, Bubble, Selection, Insertion and Quick sort against random,
   ascending and descending input arrays to compare their real-world performance
   characteristics (best case, worst case, and behavior on already-sorted data).

## Technologies

- Java 17 (no external dependencies, no build tool required)

## Project structure

| File                        | Responsibility                                                            |
|-----------------------------|-----------------------------------------------------------------------------|
| `Main.java`                 | Entry point for the custom-sort demo                                       |
| `Insertion.java`             | Insertion sort (descending order)                                          |
| `Merge.java`                 | Top-down merge sort (descending order)                                     |
| `Quick.java`                 | Quicksort over `Car[]`, ordering by a chosen attribute (descending order)   |
| `Shuffle.java`               | Fisher-Yates array shuffle helper                                          |
| `Car.java`                   | Simple `Comparable` domain object used by the Quick sort demo              |
| `numbers.txt`                 | Sample input data for `Main` (first line = element count)                  |
| `SortingAlgorithms.java`     | Ascending Merge, Bubble, Selection, Insertion and Quick sort implementations |
| `SortingAlgorithmTester.java` | Benchmarks `SortingAlgorithms` against random/ascending/descending input   |

## Building and running

Compile all sources:

```bash
javac *.java
```

Run the custom-sort demo:

```bash
java Main
```

Run the sorting algorithm benchmark:

```bash
java SortingAlgorithmTester
```

The benchmark array size is controlled by the `ARRAY_SIZE` constant in
`SortingAlgorithmTester.java`; larger values make timing differences more
pronounced but take longer to run.
