package hometask.oop.polymorphism.competition.participant;

import hometask.oop.polymorphism.competition.obstacle.Obstacle;

public class Participant {
    private final String name;
    private double maxJumpingHeight;
    private double maxRunningLengnt;
    private boolean isOvercameObstacles;

    public Participant(String name, double maxJumpingHeight, double maxRunningLengnt, boolean isOvercameObstacles) {
        this.name = name;
        this.maxJumpingHeight = maxJumpingHeight;
        this.maxRunningLengnt = maxRunningLengnt;
        this.isOvercameObstacles = isOvercameObstacles;
    }

    public String getName() {
        return name;
    }

    public void setOvercameObstacles(boolean overcameObstacles) {
        isOvercameObstacles = overcameObstacles;
    }

    public boolean isOvercameObstacles() {
        return isOvercameObstacles;
    }

    private void printRemainder() {
        System.out.println("Remainder --->  maxJumpingHeight " + maxJumpingHeight + " __ maxRunningLengnt " + maxRunningLengnt);
    }

    public void run(Obstacle obstacle) {
        if (obstacle.getDistance() <= maxRunningLengnt) {
            maxRunningLengnt -= obstacle.getDistance();
            System.out.println("Participant " + getName() + " cleared obstacle " + obstacle.getClass().getSimpleName() + " at distance " + obstacle.getDistance());
            printRemainder();
        } else {
            setOvercameObstacles(false);
            System.out.println("Participant  " + getName() + " not cleared obstacle " + obstacle.getClass().getSimpleName() + " at distance " + obstacle.getDistance() +
                               ". Cleared " + maxRunningLengnt);
            printRemainder();
        }
    }

    public void jump(Obstacle obstacle) {
        if (obstacle.getDistance() <= maxJumpingHeight) {
            maxJumpingHeight -= obstacle.getDistance();
            System.out.println("Participant " + getName() + " cleared obstacle " + obstacle.getClass().getSimpleName() + " at distance " + obstacle.getDistance());
            printRemainder();
        } else {
            setOvercameObstacles(false);
            System.out.println("Participant " + getName() + " not cleared obstacle " + obstacle.getClass().getSimpleName() + " at distance " + obstacle.getDistance() +
                               ". Cleared " + maxJumpingHeight);
            printRemainder();
        }
    }

}
