package hometask.oop.inheritance;

public abstract class Animal {
    static int instanceCount = 0;

    public Animal() {
        instanceCount++;
    }

    public abstract void run(double distance);

    public abstract void swim(double distance);

    public static int getInstanceCount() {
        return instanceCount;
    }
}
