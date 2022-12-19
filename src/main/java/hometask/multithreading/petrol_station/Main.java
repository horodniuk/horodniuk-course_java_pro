package hometask.multithreading.petrol_station;

public class Main {
    public static void main(String[] args) {
        PetrolStation station = new PetrolStation(100, PetrolStation.fillCarsQueue(3));
        System.out.println("Количество топлива на станции - " + station.getAmount());
        for (int i = 0; i < 7; i++) {
            station.doRefuel(15);
        }
    }
}
