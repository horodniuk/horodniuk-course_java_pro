package hometask.oop.polymorphism.figure;

public class Square implements Figure {
    private final double n;

    public Square(double n) {
        this.n = n;
    }

    @Override
    public double getArea() {
        return Math.pow(n, 2);
    }
}
