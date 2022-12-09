package hometask.stream;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ProductBox products = new ProductBox(new ArrayList<>(List.of(
                new Product(1, Type.BOOK, new BigDecimal(10), false, LocalDate.of(2022, 10, 10)),
                new Product(2, Type.BOOK, new BigDecimal(100), false, LocalDate.of(1998, 10, 9)),
                new Product(3, Type.BOOK, new BigDecimal(300), true, LocalDate.of(2021, 9, 10)),
                new Product(4, Type.TOY, new BigDecimal(1000), true, LocalDate.of(1999, 10, 10)),
                new Product(5, Type.BOOK, new BigDecimal(30), true, LocalDate.of(2022, 10, 9)),
                new Product(6, Type.TOY, new BigDecimal(1050), true, LocalDate.of(2002, 10, 10))
        )));
        products.getProductsByFilterTypeAndMinPrice(Type.BOOK, 250);
        products.getProductsWithDiscountByFilterType(Type.BOOK, new BigDecimal(10));
        products.getCheapestProductByFilterType(Type.BOOK);
        products.getRecentProducts(3);
        products.sumPriceByFilter(Year.of(2022), Type.TOY, 75);
        products.groupByTypeMap();
    }
}
