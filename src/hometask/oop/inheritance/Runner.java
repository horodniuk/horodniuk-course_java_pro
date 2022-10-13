package hometask.oop.inheritance;

public class Runner {
    public static void main(String[] args) {
        new Cat().run(5);
        new Cat().run(5000);


        new Dog().run(5);
        new Dog().run(5000);
        new Dog().swim(5);
        new Dog().swim(5000);

        System.out.println("counting created cats, dogs and animals - " + Animal.getCount());
        System.out.println("counting created cats - " + Cat.getCount());
        System.out.println("counting created dogs - " + Dog.getCount());

    }
}
