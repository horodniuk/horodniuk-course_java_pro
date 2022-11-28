package hometask.multithreading.value_calculator;

import java.util.Arrays;

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

        Thread threadForFirstArray = new Thread(changeValues(firstHalfArray));
        Thread threadForSecondArray = new Thread(changeValues(secondHalfArray));
        threadForFirstArray.start();
        threadForSecondArray.start();
        try {
            threadForFirstArray.join();
            threadForSecondArray.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(firstHalfArray, 0, array, 0, halfSizeArray);
        System.arraycopy(secondHalfArray, 0, array, halfSizeArray, halfSizeArray);
        System.out.printf("time execute program - %s milliseconds%n", System.currentTimeMillis() - start);
    }

    private Runnable changeValues(float[] arr) {
        return () -> assignNewValuesByFormula(arr);
    }

    private void assignNewValuesByFormula(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
