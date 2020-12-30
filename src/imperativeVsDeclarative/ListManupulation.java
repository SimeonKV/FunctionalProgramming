package imperativeVsDeclarative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListManupulation {
    final static List<String> NAMES = List.of("Brian","Nate","Neal","Sara","Maria","Marko");
    final static Function<String,Predicate<String>> wordStartingWithLetter =
            letter -> {
                 Predicate<String> nameWithStartingLetter = (String name) -> name.startsWith(letter);
                 return nameWithStartingLetter;
            };
    public static void main(String[] args) {

        iterateThroughList();
        uppercaseNames();
        countLettersInASingleName();
        filterAllNamesStartingWithLetterN();
        filterAllNamesStartingWithGivenLetter();
        NAMES
                .stream()
                .filter(wordStartingWithLetter.apply("M"))
                .forEach(name -> System.out.println(name + " "));
        System.out.println();

    }

    private static void filterAllNamesStartingWithGivenLetter() {

        System.out.println("Output");
        System.out.println("----------");
        List<String> namesWithN =
                NAMES
                        .stream()
                        .filter(startingWithLetter("N"))
                        .collect(Collectors.toList());

        List<String> namesWithB =
                NAMES
                        .stream()
                        .filter(startingWithLetter("B"))
                       .collect(Collectors.toList());

        System.out.println(namesWithN);
        System.out.println(namesWithB);
        System.out.println();

    }

    private static Predicate<String> startingWithLetter(String letter) {
        return x -> x.startsWith(letter);
    }

    private static void filterAllNamesStartingWithLetterN() {
        //Imperative approach
        System.out.println("Imperative approach");
        System.out.println("-----------");
        List<String> namesWithLetterN = new ArrayList<>();
        for(String name : NAMES){
            if(name.startsWith("N")){
                namesWithLetterN.add(name);
            }
        }

        for(String name : namesWithLetterN){
            System.out.print(name + " ");
        }
        System.out.println();

        //Declarative approach
        System.out.println("Declarative approach");
        System.out.println("-----------");
         NAMES
                .stream()
                .filter(startingWithLetter("B"))
                .forEach(name -> System.out.print(name + " "));

        System.out.println();

    }

    private static void countLettersInASingleName() {
        
        List<Integer> letterCounts =
                NAMES
                .stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(letterCounts);
        System.out.println();

    }

    private static void uppercaseNames() {
        //Imperative approach
        System.out.println("Imperative approach");
        System.out.println("-----------");
        final List<String> friendsList = new ArrayList<>();
        for(String name : NAMES){
            friendsList.add(name.toUpperCase());
        }
        System.out.println(friendsList);
        System.out.println();

        //Declarative approach
        System.out.println("Declarative approach");
        System.out.println("-----------");
        final List<String> fiendsListTwo = new ArrayList<>();
        NAMES
                .forEach(name -> fiendsListTwo.add(name.toUpperCase()));
        System.out.println(fiendsListTwo);
        System.out.println();

        //Declarative approach
        System.out.println("Declarative approach");
        System.out.println("-----------");

        List<String> friendListThree = NAMES
                .stream()
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(friendListThree);
        System.out.println();


    }

    private static void iterateThroughList() {
        System.out.println("Imperative approach");
        System.out.println("-----------");
        //Imperative approach
        for(String name : NAMES){
            System.out.println(name);
        }
        System.out.println();

        //Declarative approach
        System.out.println("Declarative approach");
        System.out.println("-----------");
        NAMES
                .forEach(name -> System.out.println(name));
        System.out.println();
    }
}
