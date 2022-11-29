package hometask.testing.custom_map;

public class Main {
    public static void main(String[] args) {
        LearningMapImpl map = new LearningMapImpl();
        map.put(7, "Seven");
        map.put(3, "Three");
        map.put(11, "Eleven");
        map.put(1, "One");
        map.put(5, "Five");
        map.put(9, "Nine");

        System.out.println(map.get(5));
        System.out.println(map.get(10));
    }
}
