/**
 * Reference implementations of five classic sorting algorithms, all sorting into ascending order.
 * Used by {@link SortingAlgorithmTester} to benchmark their performance on random,
 * ascending and descending input data.
 */
public final class SortingAlgorithms {

    private SortingAlgorithms() {
    }

    /** Merge sort: consistently fast regardless of input order, O(n log n) worst case. */
    public static void sort1(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        mergeSort(array, aux, 0, array.length - 1);
    }

    private static void mergeSort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(array, aux, low, mid);
        mergeSort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    /** Bubble sort: O(n^2), but very fast on already-sorted (ascending) input thanks to early exit. */
    public static void sort2(Comparable[] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    swap(array, i, i + 1);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    /** Selection sort: O(n^2) regardless of input order, since it always scans for the minimum. */
    public static void sort3(Comparable[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(array, i, minIndex);
            }
        }
    }

    /** Insertion sort: O(n^2) worst case, but near O(n) on already-sorted (ascending) input. */
    public static void sort4(Comparable[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            Comparable key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    /**
     * Quicksort using a median-of-three pivot selection, which keeps performance close to
     * O(n log n) even on already-sorted or reverse-sorted input by avoiding degenerate
     * (always-smallest or always-largest) pivot choices.
     */
    public static void sort5(Comparable[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Comparable[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivotIndex = medianOfThree(array, low, high);
        swap(array, pivotIndex, high);
        Comparable pivot = array[high];

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);

        quickSort(array, low, i);
        quickSort(array, i + 2, high);
    }

    private static int medianOfThree(Comparable[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        if (array[mid].compareTo(array[low]) < 0) {
            swap(array, low, mid);
        }
        if (array[high].compareTo(array[low]) < 0) {
            swap(array, low, high);
        }
        if (array[high].compareTo(array[mid]) < 0) {
            swap(array, mid, high);
        }
        return mid;
    }

    private static void swap(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
