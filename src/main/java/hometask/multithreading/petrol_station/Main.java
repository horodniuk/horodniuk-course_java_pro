package hometask.multithreading.petrol_station;

public class Main {
    public static void main(String[] args) {
        //  PetrolStation station = new PetrolStationByWaitAndNotify(1000, 3);
        PetrolStation station = new PetrolStationBySemaphore(1000, 3);
        System.out.println("Количество топлива на станции - " + station.getTotalFuelAmount());
        for (int i = 0; i < 67; i++) {
            station.doRefuel(15.0);
        }
    }

}
