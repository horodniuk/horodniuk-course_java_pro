package hometask.multithreading.petrol_station;

import com.google.common.util.concurrent.AtomicDouble;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class PetrolStationBySemaphore implements PetrolStation<AtomicDouble> {
    private AtomicDouble totalFuelAmount;
    private Semaphore availableSlots;

    public PetrolStationBySemaphore(int totalFuelAmount, int countFuelDispenser) {
        this.totalFuelAmount = new AtomicDouble(totalFuelAmount);
        this.availableSlots = new Semaphore(countFuelDispenser, true);
    }

    @Override
    public void doRefuel(Double substructFuelAmount) {
        new Thread(() -> {
            try {
                availableSlots.acquire();
                int refuelingTime = (new Random().nextInt(MAX_TIME_REFUELING_MS - MIN_TIME_REFUELING_MS) + MIN_TIME_REFUELING_MS);
                System.out.println(Thread.currentThread().getName() + " oбслуживаеться " + refuelingTime + " мс");
                Thread.sleep(refuelingTime);
                if (totalFuelAmount.get() < substructFuelAmount) {
                    System.out.println(Thread.currentThread().getName() + " - Извините топлива вам не хватит. Вы запросили:" + substructFuelAmount + ". а осталось: " + totalFuelAmount);
                    availableSlots.release();
                    return;
                } else {
                    totalFuelAmount.set((totalFuelAmount.get() - substructFuelAmount));
                    System.out.println(Thread.currentThread().getName() + " заправился. Осталось " + totalFuelAmount + " топлива");
                }
                availableSlots.release();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    @Override
    public AtomicDouble getTotalFuelAmount() {
        return totalFuelAmount;
    }
}
