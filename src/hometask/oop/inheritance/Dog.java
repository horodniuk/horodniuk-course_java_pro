package hometask.oop.inheritance;

public class Dog extends Animal {

    @Override
    public void run(double distance) {
        if (distance < 500) {
            System.out.println("Dog ran " + distance + " m.");
        } else {
            System.out.println("Dog can't run this distance " + distance + " m.");
        }
    }

    @Override
    public void swim(double distance) {
        if (distance < 10) {
            System.out.println("Dog swam " + distance + " m.");
        } else {
            System.out.println("Dog can't swam this distance " + distance + " m.");
        }
    }
}
