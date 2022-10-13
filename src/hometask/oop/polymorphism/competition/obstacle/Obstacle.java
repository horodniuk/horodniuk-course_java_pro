package hometask.oop.polymorphism.competition.obstacle;

public abstract class Obstacle {

    private double distance;

    abstract void overcome();

    public Obstacle(double distance) {
        this.distance = distance;
    }


    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
