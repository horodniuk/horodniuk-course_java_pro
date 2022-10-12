package hometask.oop.inheritance;

public class Cat extends Animal {

    @Override
    public void run(double distance) {
        if (distance < 200) {
            System.out.println("cat ran " + distance + " m.");
        } else {
            System.out.println("cat can't ran this distance " + distance + " m.");
        }
    }

    @Override
    public void swim(double distance) {
        System.out.println("cat can't swim");
    }
}
