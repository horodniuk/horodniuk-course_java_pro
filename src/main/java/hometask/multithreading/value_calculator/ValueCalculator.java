package hometask.multithreading.value_calculator;

import java.util.Arrays;
import java.util.concurrent.*;

public class ValueCalculator {
    private final int sizeArray = 1000000;
    private final int halfSizeArray = sizeArray / 2;
    private final float[] array = new float[sizeArray];

    public void doCalc() {
        long start = System.currentTimeMillis();
        Arrays.fill(array, 1);

        float[] firstHalfArray = new float[halfSizeArray];
        float[] secondHalfArray = new float[halfSizeArray];

        System.arraycopy(array, 0, firstHalfArray, 0, halfSizeArray);
        System.arraycopy(array, halfSizeArray, secondHalfArray, 0, halfSizeArray);

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<float[]> task1 = new UpdateArrayByFormula(firstHalfArray);
        Callable<float[]> task2 = new UpdateArrayByFormula(secondHalfArray);

        FutureTask<float[]> futureTask1 = new FutureTask<>(task1);
        FutureTask<float[]> futureTask2 = new FutureTask<>(task2);

        executorService.execute(futureTask1);
        executorService.execute(futureTask2);

        while (true) {
            try {
                if (futureTask1.isDone() && futureTask2.isDone()) {
                    firstHalfArray = futureTask1.get();
                    secondHalfArray = futureTask2.get();
                    executorService.shutdown();
                    break;
                }
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException("Task not executed");
            }
        }

        System.arraycopy(firstHalfArray, 0, array, 0, halfSizeArray);
        System.arraycopy(secondHalfArray, 0, array, halfSizeArray, halfSizeArray);

        System.out.printf("time execute program - %s milliseconds%n", System.currentTimeMillis() - start);
        System.out.println("Ok");
    }


    static class UpdateArrayByFormula implements Callable<float[]> {
        private final float[] array;

        public UpdateArrayByFormula(float[] arr) {
            this.array = arr;
        }

        @Override
        public float[] call() {
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            return array;
        }
    }
}
