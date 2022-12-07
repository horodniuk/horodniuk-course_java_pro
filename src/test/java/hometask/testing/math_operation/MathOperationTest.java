package hometask.testing.math_operation;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith({
        MockitoExtension.class
})
class MathOperationTest {
    @Mock
    ItemSource itemSource;
    @InjectMocks
    MathOperation operation;

    @Test
    void testMethodByPositiveItemNumbers() {
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(1, 2, 3));
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(6),
                () -> assertThat(operation.avg()).isEqualTo(2),
                () -> assertThat(operation.max()).isEqualTo(3)
        );
    }

    @Test
    void testMethodByNegativeItemNumbers() {
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(-1, -2, -3));
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(-6),
                () -> assertThat(operation.avg()).isEqualTo(-2),
                () -> assertThat(operation.max()).isEqualTo(-1)
        );
    }

    @Test
    void testMethodByZeroItemNumbers() {
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(0, 0, 0));
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(0),
                () -> assertThat(operation.avg()).isEqualTo(0),
                () -> assertThat(operation.max()).isEqualTo(0)
        );
    }

    @Test
    void testMethodByAllTypeItemNumbers() {
        Mockito.when(itemSource.getItems()).thenReturn(Arrays.asList(10, 0, -20));
        assertAll(
                () -> assertThat(operation.sum()).isEqualTo(-10),
                () -> assertThat(operation.avg()).isEqualTo(-3),
                () -> assertThat(operation.max()).isEqualTo(10)
        );
    }
}