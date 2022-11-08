package hometask.collection.data_structure.arrayList;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayListImpl array = new ArrayListImpl();
        for (int i = 0; i < 7; i++) {
            array.add(i);
        }
        System.out.println("array.toArray() - " + Arrays.toString(array.toArray()));
        array.remove(5);
        array.remove(0);
        System.out.println("array.toArray() - " + Arrays.toString(array.toArray()));
        System.out.println("array.get(0) - " + array.get(0));
        System.out.println("array.size() - " + array.size());
        System.out.println("array.isEmpty() - " + array.isEmpty());
        System.out.println("array.clear");
        array.clear();
        System.out.println("array.isEmpty() - " + array.isEmpty());
        System.out.println("array.size() - " + array.size());
        System.out.println("array.toArray() - " + Arrays.toString(array.toArray()));
    }
}
