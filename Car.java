/**
 * Represents a car with brand, model name and model year.
 * Implements Comparable so that cars can be ordered by model year.
 */
public class Car implements Comparable<Car> {

    private String brand;
    private String modelName;
    private long modelYear;

    public Car(String brand, String modelName, int modelYear) {
        this.brand = brand;
        this.modelName = modelName;
        this.modelYear = modelYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public long getModelYear() {
        return modelYear;
    }

    public void setModelYear(long modelYear) {
        this.modelYear = modelYear;
    }

    @Override
    public int compareTo(Car other) {
        return Long.compare(this.modelYear, other.modelYear);
    }

    @Override
    public String toString() {
        return brand + " " + modelName + " (" + modelYear + ")";
    }
}
