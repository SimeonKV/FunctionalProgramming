package function;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer,Double> multiplyNumberBy2 = number -> number * 2.00;
        Function<Double,Double> subtractNumberBy15 = number -> number - 15;
        Function<Double,Integer> parseToInt = num -> (int)(num * 1.00);

        Function<Integer,Integer> res = multiplyNumberBy2
                .andThen(subtractNumberBy15)
                .andThen(parseToInt);
        System.out.println(res.apply(10));


    }
}
