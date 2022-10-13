package hometask.oop.polymorphism.competition;

import hometask.oop.polymorphism.competition.obstacle.Obstacle;
import hometask.oop.polymorphism.competition.obstacle.Treadmill;
import hometask.oop.polymorphism.competition.obstacle.Wall;
import hometask.oop.polymorphism.competition.participant.Cat;
import hometask.oop.polymorphism.competition.participant.Human;
import hometask.oop.polymorphism.competition.participant.Participant;
import hometask.oop.polymorphism.competition.participant.Robot;

public class Runner {
    public static void main(String[] args) {
        Obstacle[] obstacles = {
                new Treadmill(2),
                new Treadmill(3),
                new Wall(15),
                new Treadmill(10),
                new Wall(10),
                new Wall(20),
        };

        Participant[] participants = {
                new Human("Human", 30,30, true),
                new Cat("Cat", 5, 5, true),
                new Robot("Robot", 50, 50, true)
        };

        Competition competition = new Competition(participants, obstacles);
        competition.start();


    }
}
