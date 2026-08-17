import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Demonstrates the custom sorting implementations (Insertion, Merge, Quick)
 * on both a numeric array loaded from numbers.txt and a sample array of {@link Car} objects.
 */
public class Main {

    public static void main(String[] args) {
        Comparable[] numbers = readNumbers("numbers.txt");

        Shuffle.shuffle(numbers);
        Insertion.sort(numbers);
        System.out.println("Insertion sort (descending): " + Arrays.toString(numbers));

        Shuffle.shuffle(numbers);
        Merge.sort(numbers);
        System.out.println("Merge sort (descending):     " + Arrays.toString(numbers));

        Car[] cars = {
                new Car("Toyota", "Corolla", 2021),
                new Car("Honda", "Civic", 2020),
                new Car("Ford", "Mustang", 2019),
                new Car("BMW", "M3", 2018),
                new Car("Audi", "A6", 2022),
                new Car("Chevrolet", "Impala", 2023),
                new Car("Tesla", "Model 3", 2017),
                new Car("Hyundai", "Tucson", 2016),
                new Car("Nissan", "Pathfinder", 2015),
                new Car("Mercedes-Benz", "GLE", 2014)
        };

        Quick.sort(cars, "modelyear");
        System.out.println("Quick sort (descending by model year):");
        for (Car car : cars) {
            System.out.println("  " + car);
        }
    }

    /**
     * Reads an array from a text file located on the classpath. The first line holds the
     * element count, and each following line holds one integer element.
     */
    public static Comparable[] readNumbers(String resourceName) {
        try (InputStream stream = Main.class.getResourceAsStream("/" + resourceName)) {
            if (stream == null) {
                throw new IllegalStateException("Could not find resource: " + resourceName);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
                int count = Integer.parseInt(reader.readLine().trim());
                Comparable[] array = new Comparable[count];
                for (int i = 0; i < count; i++) {
                    array[i] = Integer.parseInt(reader.readLine().trim());
                }
                return array;
            }
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read " + resourceName, e);
        }
    }
}
