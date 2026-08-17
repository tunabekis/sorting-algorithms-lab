import java.util.Comparator;

/**
 * Quicksort implementation that sorts an array of {@link Car} objects into
 * descending order according to a chosen attribute (brand, model name or model year).
 */
public final class Quick {

    private Quick() {
    }

    public static void sort(Car[] cars, String attribute) {
        Comparator<Car> comparator = comparatorFor(attribute);
        quickSort(cars, 0, cars.length - 1, comparator);
    }

    private static Comparator<Car> comparatorFor(String attribute) {
        switch (attribute.toLowerCase()) {
            case "brand":
                return Comparator.comparing(Car::getBrand);
            case "modelname":
                return Comparator.comparing(Car::getModelName);
            case "modelyear":
                return Comparator.comparingLong(Car::getModelYear);
            default:
                throw new IllegalArgumentException("Invalid attribute: " + attribute);
        }
    }

    private static void quickSort(Car[] cars, int low, int high, Comparator<Car> comparator) {
        if (low < high) {
            int pivotIndex = partition(cars, low, high, comparator);
            quickSort(cars, low, pivotIndex - 1, comparator);
            quickSort(cars, pivotIndex + 1, high, comparator);
        }
    }

    private static int partition(Car[] cars, int low, int high, Comparator<Car> comparator) {
        Car pivot = cars[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(cars[j], pivot) > 0) {
                i++;
                swap(cars, i, j);
            }
        }

        swap(cars, i + 1, high);
        return i + 1;
    }

    private static void swap(Car[] cars, int i, int j) {
        Car temp = cars[i];
        cars[i] = cars[j];
        cars[j] = temp;
    }
}
