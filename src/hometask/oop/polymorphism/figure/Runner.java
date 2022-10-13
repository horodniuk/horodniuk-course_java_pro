package hometask.oop.polymorphism.figure;

// area new Circle(1) --> 3.14
// area new Square(2) --> 4
// area new Triangle(5,5,6) --> 12
// total (3.14 + 4 + 12) --> 19.14

public class Runner {
    public static void main(String[] args) {
        Figure[] figures = {new Circle(1), new Square(2), new Triangle(5, 5, 6)};
        new Box(figures).getTotalArea();
    }
}
