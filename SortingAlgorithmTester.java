import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * Benchmarks the five sorting algorithms in {@link SortingAlgorithms} against random,
 * ascending and descending input arrays, printing how long each combination takes.
 * The relative timings reveal each algorithm's best/worst-case behavior
 * (e.g. bubble and insertion sort finish almost instantly on already-sorted input,
 * while selection sort stays slow regardless of input order).
 */
public class SortingAlgorithmTester {

    /** Size of every generated array; increase to make timing differences more pronounced. */
    private static final int ARRAY_SIZE = 50000;

    @FunctionalInterface
    private interface SortAlgorithm {
        void sort(Comparable[] array);
    }

    public static void main(String[] args) {
        Map<String, SortAlgorithm> algorithms = new LinkedHashMap<>();
        algorithms.put("sort1", SortingAlgorithms::sort1);
        algorithms.put("sort2", SortingAlgorithms::sort2);
        algorithms.put("sort3", SortingAlgorithms::sort3);
        algorithms.put("sort4", SortingAlgorithms::sort4);
        algorithms.put("sort5", SortingAlgorithms::sort5);

        Map<String, Comparable[]> datasets = new LinkedHashMap<>();
        datasets.put("random", randomArray(ARRAY_SIZE));
        datasets.put("ascending", ascendingArray(ARRAY_SIZE));
        datasets.put("descending", descendingArray(ARRAY_SIZE));

        for (Map.Entry<String, Comparable[]> dataset : datasets.entrySet()) {
            for (Map.Entry<String, SortAlgorithm> algorithm : algorithms.entrySet()) {
                long elapsedMillis = timeSort(algorithm.getValue(), dataset.getValue());
                System.out.printf("%-6s with %-10s input: %6d ms%n",
                        algorithm.getKey(), dataset.getKey(), elapsedMillis);
            }
            System.out.println("--------------------------------");
        }
    }

    /** Sorts a fresh copy of {@code original} and returns the elapsed time in milliseconds. */
    private static long timeSort(SortAlgorithm algorithm, Comparable[] original) {
        Comparable[] copy = original.clone();
        long start = System.currentTimeMillis();
        algorithm.sort(copy);
        return System.currentTimeMillis() - start;
    }

    private static Comparable[] randomArray(int size) {
        Random random = new Random();
        Comparable[] array = new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size + 1);
        }
        return array;
    }

    private static Comparable[] ascendingArray(int size) {
        Comparable[] array = new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static Comparable[] descendingArray(int size) {
        Comparable[] array = new Comparable[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
}
