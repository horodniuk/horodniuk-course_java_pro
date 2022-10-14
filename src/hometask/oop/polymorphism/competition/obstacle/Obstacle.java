package hometask.oop.polymorphism.competition.obstacle;

public abstract class Obstacle {
    private final double distance;

    public Obstacle(double distance) {
        this.distance = distance;
    }

    public double overcome() {
        return distance;
    }

}
