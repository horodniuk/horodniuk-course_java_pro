package hometask.multithreading.petrol_station;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PetrolStation {
    private Double amount;

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(double subtractAmount) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();
        futures.add(executor.submit(new Thread(changeValues(subtractAmount))));

        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }

    private Runnable changeValues(Double subtractAmount) {
        return new Runnable() {
            @Override
            public synchronized void run() {
                try {
                    Thread.sleep(generateRandomNumber(1000, 3000));
                    if (amount > subtractAmount) {
                        amount -= subtractAmount;
                        System.out.println(" subtract amount - " + subtractAmount + ". Remainder amount - " + amount);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            }
        };
    }

    private int generateRandomNumber(int minRange, int maxRange) {
        return new Random().nextInt(maxRange - minRange) + minRange;
    }
}
