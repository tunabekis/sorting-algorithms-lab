/**
 * Top-down merge sort implementation that sorts an array into descending order.
 */
public final class Merge {

    private Merge() {
    }

    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        topDownMergeSort(array, aux, 0, array.length - 1);
    }

    private static void topDownMergeSort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;
        topDownMergeSort(array, aux, low, mid);
        topDownMergeSort(array, aux, mid + 1, high);
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
            } else if (aux[i].compareTo(aux[j]) > 0) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }
    }
}
