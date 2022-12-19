package hometask.multithreading.petrol_station;

import java.util.*;

public class PetrolStation {
    private double amount;
    private Queue<FuelDispenser> carsQueue;

    public PetrolStation(double amount, Queue<FuelDispenser> carsQueue) {
        this.amount = amount;
        this.carsQueue = carsQueue;
    }

    public static Queue<FuelDispenser> fillCarsQueue(int count) {
        Queue<FuelDispenser> carsQueue = new ArrayDeque<>();
        for (int i = 0; i < count; i++) {
            carsQueue.add(new FuelDispenser());
        }
        return carsQueue;
    }

    void doRefuel(double subtrack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (carsQueue) {
                        while (true) {
                            if (!carsQueue.isEmpty()) {
                                if (amount < subtrack) {
                                    System.out.println(Thread.currentThread().getName() + " - Извините топлива вам не хватит. Вы запросили:" + subtrack + ". а осталось: " + amount);
                                    carsQueue.notify();
                                    return;
                                }
                                FuelDispenser fuelDispenser = carsQueue.remove();
                                int refuelingTime = (new Random().nextInt(10000 - 3000) + 3000);
                                System.out.println(Thread.currentThread().getName() + " oбслуживаеться " + refuelingTime + " мс на колонке -> " + fuelDispenser);
                                carsQueue.wait(refuelingTime);
                                amount = amount - subtrack;
                                System.out.println("Осталось " + amount + " топлива, " + Thread.currentThread().getName() + "  освобождает колонку -> " + fuelDispenser);
                                carsQueue.add(fuelDispenser);
                                carsQueue.notify();
                                break;
                            } else {
                                System.out.println(Thread.currentThread().getName() + " ожидает свободную колонку");
                                carsQueue.wait();
                            }
                        }
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }).start();
    }

    public double getAmount() {
        return amount;
    }
}
