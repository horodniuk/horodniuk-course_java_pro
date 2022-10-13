package hometask.oop.polymorphism.competition;

import hometask.oop.polymorphism.competition.obstacle.Obstacle;
import hometask.oop.polymorphism.competition.participant.Participant;

public class Competition {
    private final Participant[] participants;
    private final Obstacle[] obstacles;


    public Competition(Participant[] participants, Obstacle[] obstacles) {
        this.participants = participants;
        this.obstacles = obstacles;
    }

    public void start() {
        for (int i = 0; i < participants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (participants[i].isOvercameObstacles()) {
                    System.out.println();
                    if (obstacles[j].getClass().getSimpleName().equals("Treadmill")){
                        participants[i].run(obstacles[j]);
                    } else if (obstacles[j].getClass().getSimpleName().equals("Wall")) {
                        participants[i].jump(obstacles[j]);
                    }

                } else {
                    System.out.println("eliminated from participation in a series of obstacles");
                    break;
                }
            }
        }
    }
}
