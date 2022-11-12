package hometask.collection.coffee.order;

public class Order {
    static int number;
    private String customerName;

    public Order(String customerName) {
        number++;
        this.customerName = customerName;
    }

    public int getNumber() {
        return number;
    }

    public String getCustomerName() {
        return customerName;
    }
}


