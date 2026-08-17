import java.util.Random;

/**
 * Utility class for randomly shuffling arrays using the Fisher-Yates algorithm.
 */
public final class Shuffle {

    private Shuffle() {
    }

    public static <T> void shuffle(T[] array) {
        Random random = new Random();

        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
