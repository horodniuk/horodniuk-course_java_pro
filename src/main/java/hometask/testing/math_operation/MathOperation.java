package hometask.testing.math_operation;

import java.util.Collections;

public class MathOperation {
    private ItemSource itemSource;

    MathOperation(ItemSource itemSource) {
        if (itemSource.getItems().isEmpty()) {
            throw new IllegalArgumentException("Items size can't be empty or null");
        }
        this.itemSource = itemSource;
    }

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
