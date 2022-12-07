package hometask.testing.math_operation;

import java.util.Collections;

public class MathOperation {
    private ItemSource itemSource;

    int sum() {
        return itemSource.getItems()
                .stream()
                .reduce(0, Integer::sum);
    }

    int avg() {
        return this.sum() / itemSource.getItems().size();
    }

    int max() {
        return Collections.max(itemSource.getItems());
    }
}
