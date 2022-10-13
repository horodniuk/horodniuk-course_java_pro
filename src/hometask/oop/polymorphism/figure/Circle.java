package hometask.oop.polymorphism.figure;

public class Circle implements Figure {
    private final double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    public double getArea() {
        return Math.PI * (r * r);
    }

}
