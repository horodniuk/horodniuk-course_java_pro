package hometask.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@AllArgsConstructor
@Getter
public class Product {
    private int productId;
    private Type type;
    private BigDecimal price;
    private boolean discount;
    private LocalDate date;


}
