package hometask.stream;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Year;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProductBox {
    private final List<Product> products;

    public ProductBox(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProductsByFilterTypeAndMinPrice(Type typeProduct, int minPrice) {
        Predicate<Product> predicateType = product -> product.getType().equals(typeProduct);
        Predicate<Product> predicateMinPrice = product -> product.getPrice().doubleValue() > minPrice;
        return products.stream()
                .filter(predicateType.and(predicateMinPrice))
                .collect(Collectors.toList());
    }

    public List<Product> getProductsWithDiscountByFilterType(Type typeProduct, BigDecimal discontRatePercent) {
        Predicate<Product> predicateType = product -> product.getType().equals(typeProduct);
        Function<Product, BigDecimal> setDiscount = product -> (
                product.isDiscount()) ? getPriceWithDiscount(discontRatePercent, product) : product.getPrice();
        return products.stream()
                .filter(predicateType)
                .map(p -> new Product(p.getProductId(), p.getType(), setDiscount.apply(p), p.isDiscount(), p.getDate()))
                .collect(Collectors.toList());
    }

    private BigDecimal getPriceWithDiscount(BigDecimal discontRatePercent, Product product) {
        final BigDecimal ONE_HUNDRED = new BigDecimal(100);
        BigDecimal discountPrice = product.getPrice().multiply(discontRatePercent.divide(ONE_HUNDRED));
        return product.getPrice().subtract(discountPrice).setScale(2);
    }

    public Product getCheapestProductByFilterType(Type typeProduct) {
        Predicate<Product> predicateType = product -> product.getType().equals(typeProduct);
        Comparator<Product> comparatorCheapestProduct = Comparator.comparingInt(p -> p.getPrice().intValue());
        return products.stream()
                .filter(predicateType)
                .min(comparatorCheapestProduct).orElseThrow(
                        () -> new IllegalArgumentException("Product [Category - " + typeProduct + "] not found"));
    }

    public List<Product> getRecentProducts(int countRecentProducts) {
        Comparator<Product> comparatorPerDate = Comparator.comparing(Product::getDate);
        return products.stream()
                .sorted(comparatorPerDate)
                .limit(countRecentProducts)
                .collect(Collectors.toList());
    }

    public BigDecimal sumPriceByFilter(Year year, Type typeProduct, int maxPrice) {
        Predicate<Product> predicateDate = product -> product.getDate().getYear() == year.getValue();
        Predicate<Product> predicateType = product -> product.getType().equals(typeProduct);
        Predicate<Product> predicateMaxPrice = product -> product.getPrice().doubleValue() < maxPrice;
        return products.stream()
                .filter(predicateDate.and(predicateType.and(predicateMaxPrice)))
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public Map<Type, List<Product>> groupByTypeMap() {
        final Function<Product, Type> groupByType = Product::getType;
        return products.stream()
                .collect(Collectors.groupingBy(groupByType));
    }
}





















