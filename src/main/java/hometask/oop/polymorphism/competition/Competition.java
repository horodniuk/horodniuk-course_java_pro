package hometask.oop.polymorphism.competition;

import hometask.oop.polymorphism.competition.obstacle.Obstacle;
import hometask.oop.polymorphism.competition.obstacle.Treadmill;
import hometask.oop.polymorphism.competition.obstacle.Wall;
import hometask.oop.polymorphism.competition.participant.Participant;

public class Competition {
    private final Participant[] participants;
    private final Obstacle[] obstacles;

    public Competition(Participant[] participants, Obstacle[] obstacles) {
        this.participants = participants;
        this.obstacles = obstacles;
    }

    public void start() {
        for (Participant participant : participants) {
            for (int j = 0; j < obstacles.length; j++) {
                if (participant.isOvercameObstacles()) {
                    System.out.println();
                    obstacles[j].overcome(participant);
                } else {
                    System.out.println("participant exclude from  in a series of obstacles");
                    break;
                }
            }
        }
    }
}
