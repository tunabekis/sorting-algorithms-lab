/**
 * Insertion sort implementation that sorts an array into descending order,
 * inserting each element by walking it from right to left.
 */
public final class Insertion {

    private Insertion() {
    }

    public static void sort(Comparable[] array) {
        int n = array.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n - 1; j++) {
                if (array[j].compareTo(array[j + 1]) < 0) {
                    exchange(array, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void exchange(Comparable[] array, int a, int b) {
        Comparable temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
