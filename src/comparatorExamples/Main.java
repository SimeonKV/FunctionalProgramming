package comparatorExamples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    static final List<Person> PEOPLE = Arrays.asList(
            new Person("John",20),
            new Person("Sara",21),
            new Person("Jane",21),
            new Person("Greg",35)
    );

    public static void main(String[] args) {

        ascendingAge();
        descendingAge();
        ascendingName();
        descednigName();
        youngestPerson();
        olderstPerson();

    }

    private static void olderstPerson() {
        Optional<Person> oldest = PEOPLE
                .stream()
                .max(sortPeopleByAgeInASCOrder());

        oldest.ifPresent(Main::printPerson);
    }

    private static void youngestPerson() {
        Optional<Person> youngest = PEOPLE
                .stream()
                .min(sortPeopleByAgeInASCOrder());

        youngest.ifPresent(Main::printPerson);


    }

    private static void descednigName() {
        //Sort people by name in DESC order
        PEOPLE
                .stream()
                .sorted(sortPeopleByAgeInDescOrder())
                .forEach(Main::printPerson);
    }

    private static void ascendingName() {
        //Sort people by name in ASC order
        PEOPLE
                .stream()
                .sorted(sortPeopleByNameInDescOrder())
                .forEach(Main::printPerson);


    }

    private static void descendingAge() {
        //Sort people by age in DESC order

        PEOPLE
                .stream()
                .sorted(sortPeopleByAgeInDescOrder())
                .forEach(Main::printPerson);

    }

    private static void ascendingAge() {
        //Sort people by age in ASC order
       List<Person> peopleSortByAgeASC = PEOPLE
                .stream()
                .sorted(sortPeopleByAgeInASCOrder())
                .collect(Collectors.toList());
       peopleSortByAgeASC.forEach(Main::printPerson);
    }

    private  static  Comparator<Person> sortPeopleByNameInDescOrder(){
        return sortPeopleByNameInASCOrder().reversed();
    }

    private static Comparator<Person> sortPeopleByNameInASCOrder(){
     return (personOne,personTwo) -> personOne.getName().compareTo(personTwo.getName());
    }

    private static Comparator<Person> sortPeopleByAgeInDescOrder(){
        return sortPeopleByAgeInASCOrder().reversed();
    }

    private static Comparator<Person> sortPeopleByAgeInASCOrder(){
        return (personOne,personTwo) -> personOne.ageDifference(personTwo);
    }

    private static void printPerson(Person person) {
        System.out.print(person.toString() + " ");
        System.out.println();
    }
}
