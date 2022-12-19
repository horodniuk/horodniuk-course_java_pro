package hometask.multithreading.petrol_station;

public class FuelDispenser {
    private static int generator = 1;
    private final int id;

    public FuelDispenser() {
        this.id = generator++;
    }

    @Override
    public String toString() {
        return "{" +
               "id=" + id +
               '}';
    }
}
