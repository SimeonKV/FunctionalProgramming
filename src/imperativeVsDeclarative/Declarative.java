package imperativeVsDeclarative;

import java.util.List;
import java.util.stream.Collectors;
/*
 * credit: This example was taken from the youtube channel - "Amigoscode";
 *Filter out all females in the people list;
 * Declarative approach
 * */
public class Declarative {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice",Gender.FEMALE),
                new Person("Bob",Gender.MALE),
                new Person("Maria",Gender.FEMALE),
                new Person("Will",Gender.MALE),
                new Person("Amy",Gender.FEMALE)
        );

        List<Person> females = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        females.forEach(female -> System.out.print(female + " "));
    }
}
