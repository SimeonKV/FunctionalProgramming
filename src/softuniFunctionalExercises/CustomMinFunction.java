package softuniFunctionalExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.IntFunction;

/*
* Write a simple program that reads a set of numbers from the console and
* finds the smallest of the numbers using a simple Function<Integer[], Integer> .
* */
public class CustomMinFunction {
    static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        Integer[] numbers = readInput();
        System.out.println(findMinNumberFunction().apply(numbers));
        System.out.println();


    }

    private static Function<Integer[],Integer> findMinNumberFunction() {
        return x -> Arrays.stream(x).min(Integer::compareTo).get();
    }

    private static Integer[] readInput() {
        return Arrays.stream(SCANNER.nextLine().split(" "))
                .map(element -> new Integer(element))
                .toArray(Integer[]::new);
    }
}
