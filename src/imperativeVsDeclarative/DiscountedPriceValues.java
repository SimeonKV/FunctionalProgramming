package imperativeVsDeclarative;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/*
* Filter out all the prices which are higher than 20 and then discount each with 10 percent and simultaneously add them to
* a variable which holds the total of all discounted prices.
* */
public class DiscountedPriceValues {
    public static void main(String[] args) {
        List<BigDecimal> prices = Arrays.asList(
                new BigDecimal("10"),
                new BigDecimal("30"),
                new BigDecimal("17"),
                new BigDecimal("18"),
                new BigDecimal("20"),
                new BigDecimal("15"),
                new BigDecimal("45"),
                new BigDecimal("15")
        );

        // THE IMPERATIVE APPROACH
        BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;
        for(BigDecimal price : prices){
            if(price.compareTo(BigDecimal.valueOf(20)) > 0){
                totalOfDiscountedPrices = totalOfDiscountedPrices.add(price.multiply(BigDecimal.valueOf(0.90)));
            }
        }

        System.out.println("Total of discounted prices: " + totalOfDiscountedPrices);

        // THE DECLARATIVE(FUNCTIONAL) APPROACH
       BigDecimal discountedPricesTotal = prices
                .stream()
                .filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0)
                .map(price -> price.multiply(BigDecimal.valueOf(0.90)))
                .reduce((x,x2) -> x.add(x2)).orElse(BigDecimal.valueOf(0));

        System.out.println("Total of discounted prices: " + discountedPricesTotal);


    }
}
