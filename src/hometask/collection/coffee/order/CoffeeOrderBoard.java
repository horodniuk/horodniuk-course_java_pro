package hometask.collection.coffee.order;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeOrderBoard {
    private Map<Integer, Order> orders;

    public CoffeeOrderBoard() {
        orders = new LinkedHashMap<>();
    }

    ;

    public void add(Order order) {
        orders.put(order.getNumber(), order);
    }

    public void deliver() {
        Integer getFirstIndexKey = orders.entrySet().iterator().next().getKey();
        orders.remove(getFirstIndexKey);
    }

    public void deliver(int numberOrder) {
        orders.remove(numberOrder);
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Integer numberOrder : orders.keySet()) {
            System.out.printf("%3d | %s%n", numberOrder, orders.get(numberOrder).getCustomerName());
        }
    }


}
