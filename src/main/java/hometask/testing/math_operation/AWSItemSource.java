package hometask.testing.math_operation;

import java.util.List;

public class AWSItemSource implements ItemSource {
    private List<Integer> awsItems;

    public AWSItemSource(List<Integer> container) {
        this.awsItems = awsItems;
    }

    @Override
    public List<Integer> getItems() {
        return awsItems;
    }
}
