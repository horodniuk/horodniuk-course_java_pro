package hometask.oop.polymorphism.competition.obstacle;

import hometask.oop.polymorphism.competition.participant.Participant;

public class Wall extends Obstacle {

    public Wall(double distance) {
        super(distance);
    }

    @Override
    public void overcome(Participant participant) {
        participant.jump(this);
    }
}
