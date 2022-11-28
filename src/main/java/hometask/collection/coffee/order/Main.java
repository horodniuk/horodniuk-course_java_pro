package hometask.collection.coffee.order;

public class Main {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add(new Order("Alina"));
        coffeeOrderBoard.add(new Order("Kira"));
        coffeeOrderBoard.add(new Order("Mila"));
        coffeeOrderBoard.add(new Order("Nadia"));
        coffeeOrderBoard.add(new Order("Nina"));

        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.draw();
    }
}
