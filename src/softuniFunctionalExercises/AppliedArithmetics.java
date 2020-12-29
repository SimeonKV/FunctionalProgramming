package softuniFunctionalExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
* On the first line you are given a list of numbers.
* On the next lines you are passed different commands that you need to apply to all numbers in the list: "add" -> adds 1;
*  "multiply" -> multiplies by 2; "subtract" -> subtracts 1; "print" -> prints
 * */
public class AppliedArithmetics {
    static Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> numbers = readInput();




    }

    private static List<Integer> readInput() {
        return Arrays
                .stream(SCANNER.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
