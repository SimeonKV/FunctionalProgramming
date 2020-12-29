package softuniFunctionalExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/*Write a program that reads a collection of names as strings from the console and then appends
“Sir” in front of every name and prints it back onto the console. Use a Consumer<T>.
* */
public class KnightsOfHonor {
    static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        List<String> names = readInput();
        names
                .forEach(name -> giveHonor().accept(name));

    }

    private static Consumer<String> giveHonor() {
        return x -> System.out.println("Sir " + x);
    }

    private static List<String> readInput() {
        return Arrays
                .stream(SCANNER.nextLine().split(" "))
                .collect(Collectors.toList());
    }
}
