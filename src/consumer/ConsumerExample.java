package consumer;

import imperativeVsDeclarative.Gender;
import imperativeVsDeclarative.Person;
import java.util.function.Consumer;

public class ConsumerExample {
    static Consumer<Person> greetingPerson =
            person -> System.out.println("Hello, " + person.getName() + " thanks for stopping by to learn about consumers");
    public static void main(String[] args) {
        Person person = new Person("Simeon", Gender.MALE);
        greetingPerson.accept(person);

    }
}
