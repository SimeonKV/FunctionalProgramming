package imperativeVsDeclarative;

import java.util.ArrayList;
import java.util.List;

/*
* credit: This example was taken from the youtube channel - "Amigoscode";
*Filter out all females in the people list;
* Imperative approach
* */
public class Imperative {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Alice",Gender.FEMALE),
                new Person("Bob",Gender.MALE),
                new Person("Maria",Gender.FEMALE),
                new Person("Will",Gender.MALE),
                new Person("Amy",Gender.FEMALE)
        );

        //Imperative approach
        List<Person> females = new ArrayList<>();

        for(Person person : people){
            if(person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }

        for(Person female : females){
            System.out.println(female);
        }

    }
}
