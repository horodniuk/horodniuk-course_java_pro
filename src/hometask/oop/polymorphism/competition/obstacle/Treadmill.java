package hometask.oop.polymorphism.competition.obstacle;

public class Treadmill extends Obstacle {


    public Treadmill( double distance) {
        super(distance);
    }

    @Override
    void overcome() {
        System.out.println("overcome an obstacle treadmill");
    }
}
