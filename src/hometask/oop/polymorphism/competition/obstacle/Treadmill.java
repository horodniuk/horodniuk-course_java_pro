package hometask.oop.polymorphism.competition.obstacle;


import hometask.oop.polymorphism.competition.participant.Participant;

public class Treadmill extends Obstacle {

    public Treadmill(double distance) {
        super(distance);
    }

    @Override
    public void overcome(Participant participant) {
        participant.run(this);
    }
}
