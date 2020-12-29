package softuniFunctionalExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/*
* Write a program that reads a collection of strings, separated by one or more whitespaces,
* from the console and then prints them onto the console.
* Each string should be printed on a new line. Use a Consumer<T>.
* */
public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        names
                .forEach(name -> printNames().accept(name));





    }

    private static Consumer<String> printNames() {
        return x -> System.out.println(x);
    }
}
