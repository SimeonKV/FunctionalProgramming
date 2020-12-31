package streamAPIExamples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;

/*
* Find total number of characters in a list of names;
* */
public class Main {
  static List<String> NAMES = Arrays.asList(
            "Maria", "Mario",
            "Martin","Dimitar",
            "Georgi","Yoana");
    public static void main(String[] args) {
       exampleOne();
       exampleTwo();
       exampleThree();
       exampleFour();



    }

    private static void exampleFour() {
        //Iterate through a string;
        String name = NAMES.get(0);
        name
                .chars()
                .forEach(Main::convertIntToChar);


    }

    private static void convertIntToChar(int intAsChar) {
        System.out.println((char) intAsChar);
    }

    private static void exampleThree() {
        //convert list to string using collect joining
        //all names must be in UPPER CASE
        String allNamesInStr =NAMES
                .stream()
                .map(String::toUpperCase)
                .collect(joining(", "));
        System.out.println(allNamesInStr);
    }

    private static void exampleTwo() {
        //concat all names with reduce
        Optional<String> reduce = NAMES
                .stream()
                .reduce((nameFirst, nameSecond) -> nameFirst + ", " + nameSecond);
        System.out.println(reduce.get());
    }

    private static void exampleOne() {
        int sum = NAMES
                .stream()
                .mapToInt(String::length)
                .sum();
        System.out.println("Total number of characters in all names is: " + sum);
    }
}
