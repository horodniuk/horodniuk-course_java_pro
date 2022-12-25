package hometask.multithreading.petrol_station;

public interface PetrolStation<T extends Number> {
    int MIN_TIME_REFUELING_MS = 3000;
    int MAX_TIME_REFUELING_MS = 10000;

    void doRefuel(Double substructFuelAmount);

    T getTotalFuelAmount();
}
