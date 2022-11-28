package hometask.multithreading.petrol_station;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        PetrolStation station = new PetrolStation(150.0);
        station.doRefuel(10.0);
        station.doRefuel(15.0);
        station.doRefuel(20.0);
        station.doRefuel(25.0);
        station.doRefuel(30.0);
        station.doRefuel(35.0);
    }
}
