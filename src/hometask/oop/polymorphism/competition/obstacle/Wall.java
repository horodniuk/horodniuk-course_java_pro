package hometask.oop.polymorphism.competition.obstacle;

public class Wall extends Obstacle {


    public Wall(double distance) {
        super(distance);
    }

    @Override
    void overcome() {
        System.out.println("overcome an obstacle wall");
    }
}
