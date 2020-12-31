package optionalExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        exampleOne();
        exampleTwo();
        exampleThree();


    }

    private static void exampleThree() {
        //Find longest name
        List<String>  names = List.of("Nate","Nill","Anna","Amy","Maria","Marko","Alice","Bob","Bryan","Nelly");

        Optional<String> longestName =
                names.stream()
                .reduce((name1,name2)
                        -> name1.length() >= name2.length() ? name1 : name2);

        System.out.println(longestName.orElse("List is empty"));

    }

    private static void exampleOne() {
        //Find the first name in a list starting with given a first letter
        List<String>  names = List.of("Nate","Nill","Anna","Amy","Maria","Marko","Alice","Bob","Bryan","Nelly");

        Optional<String> nameStartingWithLetterN =
                names.stream().filter(name -> name.startsWith("N")).findFirst();
        System.out.println(nameStartingWithLetterN.orElse("No name found starting with letter N"));
    }

    private static void exampleTwo() {
        //Create a non-static method that returns a optional
        //Condition of the method -> Find the first name in a list starting with given a first letter
        List<String>  names = List.of("Nate","Nill","Anna","Amy","Maria","Marko","Alice","Bob","Bryan","Nelly");

        Main main = new Main();

        Optional<String> name = main.findNameStartingWithLetter("N",names);
        System.out.println(name.orElse("No such name found"));

        Optional<String> nameTwo = main.findNameStartingWithLetter("Z",names);
        System.out.println(nameTwo.orElse("No such name found"));
    }

    private  Optional<String> findNameStartingWithLetter(final String letter,final List<String> names){
      return   names
                .stream()
                .filter(name -> name.startsWith(letter))
                .findFirst();

    }
}
