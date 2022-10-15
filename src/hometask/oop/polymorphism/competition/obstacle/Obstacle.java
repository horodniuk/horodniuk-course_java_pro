package hometask.oop.polymorphism.competition.obstacle;

import hometask.oop.polymorphism.competition.participant.Participant;

public abstract class Obstacle {
    private final double distance;

    public Obstacle(double distance) {
        this.distance = distance;
    }

    public abstract void overcome(Participant participant);

    public double getDistance() {
        return distance;
    }

}
