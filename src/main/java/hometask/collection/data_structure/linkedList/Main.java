package hometask.collection.data_structure.linkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinkedListImpl list = new LinkedListImpl();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        System.out.println("list.toArray() - " + Arrays.toString(list.toArray()));
        list.remove(1);
        System.out.println("list.toArray() - " + Arrays.toString(list.toArray()));
        System.out.println("list.get(0) - " + list.get(0));
        System.out.println("list.size() - " + list.size());
        System.out.println("list.isEmpty() - " + list.isEmpty());
        System.out.println("list.clear");
        list.clear();
        System.out.println("list.isEmpty() - " + list.isEmpty());
        System.out.println("list.size() - " + list.size());
        System.out.println("list.toArray() - " + Arrays.toString(list.toArray()));
    }
}
