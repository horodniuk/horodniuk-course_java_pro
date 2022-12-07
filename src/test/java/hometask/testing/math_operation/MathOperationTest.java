package hometask.testing.math_operation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MathOperationTest {
    private MathOperation operation;

    @Test
    void throwExceptionIfItemInItemSourceIsEmptyOrNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            ItemSource itemSource = Mockito.mock(ItemSource.class);
            Mockito.when(itemSource.getItems()).thenReturn(Collections.emptyList());
            new MathOperation(itemSource);
        });
    }

    @Test
    void testMethodByPositiveItemNumbers() {
        ItemSource itemSource = Mockito.mock(ItemSource.class);
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(1, 2, 3));
        operation = new MathOperation(itemSource);
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(6),
                () -> assertThat(operation.avg()).isEqualTo(2),
                () -> assertThat(operation.max()).isEqualTo(3)
        );
    }

    @Test
    void testMethodByNegativeItemNumbers() {
        ItemSource itemSource = Mockito.mock(ItemSource.class);
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(-1, -2, -3));
        operation = new MathOperation(itemSource);
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(-6),
                () -> assertThat(operation.avg()).isEqualTo(-2),
                () -> assertThat(operation.max()).isEqualTo(-1)
        );
    }

    @Test
    void testMethodByZeroItemNumbers() {
        ItemSource itemSource = Mockito.mock(ItemSource.class);
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0));
        operation = new MathOperation(itemSource);
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(0),
                () -> assertThat(operation.avg()).isEqualTo(0),
                () -> assertThat(operation.max()).isEqualTo(0)
        );
    }

    @Test
    void testMethodByAllTypeItemNumbers() {
        ItemSource itemSource = Mockito.mock(ItemSource.class);
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(10, 0, -20));
        operation = new MathOperation(itemSource);
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(-10),
                () -> assertThat(operation.avg()).isEqualTo(-3),
                () -> assertThat(operation.max()).isEqualTo(10)
        );
    }
}