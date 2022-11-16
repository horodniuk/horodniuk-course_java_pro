package hometask.collection.coffee.order;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeOrderBoard {
    private static int ordersNumber;
    private Map<Integer, Order> ordersMap;

    public CoffeeOrderBoard() {
        ordersMap = new LinkedHashMap<>();
    }

    public void add(Order order) {
        ordersMap.put(ordersNumber++, order);
    }

    public void deliver() {
        Integer getFirstIndexKey = ordersMap.entrySet().iterator().next().getKey();
        ordersMap.remove(getFirstIndexKey);
    }

    public void deliver(int numberOrder) {
        ordersMap.remove(numberOrder);
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Integer numberOrder : ordersMap.keySet()) {
            System.out.printf("%3d | %s%n", numberOrder, ordersMap.get(numberOrder).getCustomerName());
        }
    }
}
