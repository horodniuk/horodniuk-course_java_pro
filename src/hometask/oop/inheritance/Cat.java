package hometask.oop.inheritance;

public class Cat extends Animal {
    static int count = 0;

    public Cat() {
        count++;
    }

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
        try {
            throw new Exception("cat can't swam");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getCount() {
        return count;
    }
}
