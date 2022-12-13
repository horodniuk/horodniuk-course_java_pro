package hometask.generic.fruit;

import java.util.ArrayList;
import java.util.List;


public class Box<T extends Fruit> implements Comparable<Box> {
    private static final float WEIGHT_EMPTY_BOX = 0.0F;
    private List<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    @Override
    public int compareTo(Box secondFruits) {
        return (int) (this.getWeight() - (secondFruits.getWeight()));
    }

    public boolean compare(Box secondFruits) {
        return (compareTo(secondFruits) == 0);
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void addAll(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getWeight() {
        return fruits.stream()
                .findFirst()
                .map(fruit -> fruit.getWeight() * fruits.size())
                .orElse(WEIGHT_EMPTY_BOX);
    }

    public void merge(Box<T> otherFruits) {
        fruits.addAll(otherFruits.getFruits());
        otherFruits.getFruits().clear();
    }

}
