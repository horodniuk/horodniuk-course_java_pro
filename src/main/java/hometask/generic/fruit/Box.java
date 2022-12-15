package hometask.generic.fruit;

import java.util.ArrayList;
import java.util.List;


public class Box<T extends Fruit> {
    private static final float WEIGHT_EMPTY_BOX = 0.0F;
    private final List<T> fruits;

    public Box() {
        fruits = new ArrayList<T>();
    }

    public List<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box<?> secondFruits) {
        return (this.getWeight() == secondFruits.getWeight());
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public void addAll(List<T> fruits) {
        this.fruits.addAll(fruits);
    }

    public float getWeight() {
        return fruits.isEmpty() ? WEIGHT_EMPTY_BOX : fruits.iterator().next().getWeight() * fruits.size();
    }

    public void merge(Box<T> otherFruits) {
        fruits.addAll(otherFruits.getFruits());
        otherFruits.getFruits().clear();
    }
}
