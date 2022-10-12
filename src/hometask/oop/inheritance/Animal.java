package hometask.oop.inheritance;

public abstract class Animal {
    static int count = 0;

    public Animal() {
        count++;
    }

    public abstract void run (double distance);

    public abstract void swim(double distance);

    public static int getCount() {
        return count;
    }
}
