package hometask.oop.polymorphism.figure;

public class Box {
    private final Figure[] figures;

    public Box(Figure[] figures) {
        this.figures = figures;
    }

    public double getTotalArea() {
        double result = 0;
        for (Figure f : figures) {
            result += f.getArea();
        }
        return result;
    }
}
