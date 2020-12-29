package function;

import java.util.function.BiFunction;

public class BiFunctionExample {
    static BiFunction<Integer,Double,Double> addBy1AndMultiplyBy10 = (num1,num2) -> (num1 + 1 + num2 + 1) + (num1 * 10 + num2 * 10);

    public static void main(String[] args) {
        Double apply = addBy1AndMultiplyBy10.apply(2, 10d);
        System.out.println(apply);
    }

}
