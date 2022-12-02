package hometask.testing.custom_map;

public class Main {
    public static void main(String[] args) {
        LearningMapImpl map = new LearningMapImpl(4);
        map.put(1, "One");
        map.put(1, "1");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
    }
}
