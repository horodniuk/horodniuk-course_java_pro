package hometask.collection.collections_lists.occurrence;

import java.util.*;

public class Occurrence {

    public List<Integer> toList(int[] array) {
        List<Integer> list = new ArrayList<>(array.length);
        for (int element : array) {
            list.add(element);
        }
        return list;
    }

    public List<Integer> findUnique(List<Integer> list) {
        return new ArrayList<>(new HashSet<>(list));
    }

    public int countOccurrence(List<String> strings, String searchString) {
        return Collections.frequency(strings, searchString);
    }

    public void calcOccurance(List<String> list) {
        System.out.println(findOccurrence(list));
    }

    public Map<String, Integer> findOccurrence(List<String> list) {
        Map<String, Integer> occurrenceMap = new HashMap<>();
        for (String currentString : list) {
            Integer countWord = occurrenceMap.get(currentString);
            if (countWord == null)
                occurrenceMap.put(currentString, 1);
            else {
                occurrenceMap.put(currentString, countWord + 1);
            }
        }
        return occurrenceMap;
    }

}
