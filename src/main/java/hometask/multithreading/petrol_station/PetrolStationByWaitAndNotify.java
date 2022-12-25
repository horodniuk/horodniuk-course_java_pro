package hometask.multithreading.petrol_station;

import java.util.*;

public class PetrolStationByWaitAndNotify implements PetrolStation<Double> {
    private double totalFuelAmount;
    private Queue<FuelDispenser> availableSlots = new ArrayDeque<>();

    public PetrolStationByWaitAndNotify(double totalFuelAmount, int countFuelDispenser) {
        this.totalFuelAmount = totalFuelAmount;
        putAvailableSlot(countFuelDispenser);
    }

    @Override
    public void doRefuel(Double substructFuelAmount) {
        new Thread(() -> {
            try {
                synchronized (availableSlots) {
                    while (true) {
                        if (!availableSlots.isEmpty()) {
                            if (totalFuelAmount < substructFuelAmount) {
                                System.out.println(Thread.currentThread().getName() + " - Извините топлива вам не хватит. Вы запросили:" + substructFuelAmount + ". а осталось: " + totalFuelAmount);
                                availableSlots.notify();
                                return;
                            }
                            FuelDispenser fuelDispenser = availableSlots.remove();
                            int refuelingTime = (new Random().nextInt(MAX_TIME_REFUELING_MS - MIN_TIME_REFUELING_MS) + MIN_TIME_REFUELING_MS);
                            System.out.println(Thread.currentThread().getName() + " oбслуживаеться " + refuelingTime + " мс на колонке -> " + fuelDispenser);

                            availableSlots.wait(refuelingTime);
                            totalFuelAmount = totalFuelAmount - substructFuelAmount;
                            System.out.println("Осталось " + totalFuelAmount + " топлива, " + Thread.currentThread().getName() + "  освобождает колонку -> " + fuelDispenser);

                            availableSlots.add(fuelDispenser);
                            availableSlots.notify();
                            break;
                        } else {
                            System.out.println(Thread.currentThread().getName() + " ожидает свободную колонку");
                            availableSlots.wait();
                        }
                    }
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    private Queue<FuelDispenser> putAvailableSlot(int countFuelDispenser) {
        for (int i = 0; i < countFuelDispenser; i++) {
            availableSlots.add(new FuelDispenser());
        }
        return availableSlots;
    }

    @Override
    public Double getTotalFuelAmount() {
        return totalFuelAmount;
    }
}
