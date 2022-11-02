package hometask.multithreading.value_calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ValueCalculator {
    private final int size = 1000000;
    private final int half = size / 2;
    private final float[] arr = new float[size];

    public void doCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(arr, 1);

        float[] a1 = new float[half];
        float[] a2 = new float[half];
        System.arraycopy(arr, 0, a1, 0, half);
        System.arraycopy(arr, half, a2, 0, half);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> futures = new ArrayList<>();
        futures.add(executor.submit(new Thread(changeValues(a1))));
        futures.add(executor.submit(new Thread(changeValues(a2))));

        for (Future<?> f : futures) {
            try {
                f.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        System.arraycopy(a1, 0, arr, 0, half);
        System.arraycopy(a2, 0, arr, half, half);

        System.out.printf("time execute program - %s milliseconds%n", System.currentTimeMillis() - start);
    }

    private Runnable changeValues(float[] arr) {
        return new Runnable() {
            @Override
            public void run() {
                ValueCalculator.this.assignNewValuesByFormula(arr);
            }
        };
    }

    private void assignNewValuesByFormula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
