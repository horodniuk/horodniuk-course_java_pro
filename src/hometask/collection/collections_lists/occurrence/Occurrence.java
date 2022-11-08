package hometask.collection.collections_lists.occurrence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Occurrence {
    private String name;
    private int countRepeat;

    public Occurrence() {
    }

    public Occurrence(String name, int countRepeat) {
        this.name = name;
        this.countRepeat = countRepeat;
    }

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
        int searchStringCount = 0;
        for (String string : strings) {
            if (string.equals(searchString)) {
                searchStringCount++;
            }
        }
        return searchStringCount;
    }

    public void calcOccurance(List<String> list) {
        List<String> blackList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentStr = list.get(i);
            if (!isStingInBlackList(blackList, currentStr)) {
                System.out.println(list.get(i) + " : " + countOccurrence(list, currentStr));
                blackList.add(currentStr);
            }
        }
    }

    private boolean isStingInBlackList(List<String> blackList, String serchingStr) {
        for (String sting : blackList) {
            if (sting.equals(serchingStr)) return true;
        }
        return false;
    }

    public List<Occurrence> findOccurrence(List<String> list) {
        List<Occurrence> occurrenceStructure = new ArrayList<>();
        List<String> blackList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentStr = list.get(i);
            if (!isStingInBlackList(blackList, currentStr)) {
                occurrenceStructure.add(new Occurrence(String.valueOf(currentStr), countOccurrence(list, currentStr)));
                blackList.add(currentStr);
            }
        }
        return occurrenceStructure;
    }

    @Override
    public String toString() {
        return '[' +
               "name='" + name + '\'' +
               ", occurrence=" + countRepeat +
               ']';
    }
}
