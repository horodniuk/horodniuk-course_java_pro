package hometask.collection.collections_lists.occurrence;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Occurrence occurrence = new Occurrence();
        int[] arrayOfInteger = new int[]{1, 2, 3, 4, 5};
        List<Integer> listOfInteger = Arrays.asList(1, 2, 1, 2, 3);
        List<String> listOfString = Arrays.asList("bird", "bird", "fox", "cat", "cat");
        occurrence.toList(arrayOfInteger);
        occurrence.findUnique(listOfInteger);
        occurrence.calcOccurance(listOfString);
        occurrence.findOccurrence(listOfString);
    }
}
