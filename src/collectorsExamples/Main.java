package collectorsExamples;

import comparatorExamples.Person;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    static final List<Person> PEOPLE = Arrays.asList(
            new Person("John",20),
            new Person("Sara",21),
            new Person("Jane",21),
            new Person("Greg",35)
    );

    static final List<Item> ITEMS = Arrays.asList(
            new Item("apple", 10, new BigDecimal("9.99")),
            new Item("banana", 20, new BigDecimal("19.99")),
            new Item("orang", 10, new BigDecimal("29.99")),
            new Item("watermelon", 10, new BigDecimal("29.99")),
            new Item("papaya", 20, new BigDecimal("9.99")),
            new Item("apple", 10, new BigDecimal("9.99")),
            new Item("banana", 10, new BigDecimal("19.99")),
            new Item("apple", 20, new BigDecimal("9.99"))

    );

    public static void main(String[] args) {

      //  exampleOne();
        exampleTwo();

    }

    private static void exampleTwo() {
        //groupingBy

        //Group by item name and get their count
        Map<String,Long> itemsAndCount =
                ITEMS
                .stream()
                .collect(
                        Collectors.groupingBy(Item::getName,Collectors.counting())
                );


        itemsAndCount.forEach((item,count) -> System.out.println(item + " " + count));

        //group by item name and compute their quantity
        Map<String,Long> itemsAndQuantity =
                ITEMS
                .stream()
                .collect(Collectors.groupingBy(Item::getName,Collectors.summingLong(Item::getQuantity)));

        itemsAndQuantity.forEach((item,qty) -> System.out.println(item + " " + qty));


        //group by item price
        Map<BigDecimal,List<Item>> priceAndItems = ITEMS
                .stream()
                .collect(Collectors.groupingBy(Item::getPrice));

        priceAndItems.forEach((price,items) -> {
            System.out.print(price + "---> ");
            items.forEach(item -> System.out.println(item.toString()));

        });

        //group people by age
        Map<Integer,List<Person>> ageAndPeople = PEOPLE
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        ageAndPeople.forEach((age,person) ->{
            System.out.print(age + "---> ");
            person.forEach(p -> System.out.println(p.toString()) );
        });

        //group people by age and get their names
        Map<Integer,String> ageAndAllNames =
                PEOPLE.
                        stream()
                        .collect(Collectors.groupingBy(Person::getAge,
                                Collectors.mapping(Person::getName,Collectors.joining(", "))));

        ageAndAllNames.forEach((age,name) -> System.out.println(age + "--> " + name));

        Map<Integer,List<String>> ageAndAllNamess =
                PEOPLE.
                        stream()
                        .collect(Collectors.groupingBy(Person::getAge,
                                Collectors.mapping(Person::getName,Collectors.toList())));

        System.out.println();

    }

    private static void exampleOne() {
        //toList method

        List<Person> peopleOlderThan20 = PEOPLE.stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toList());

        peopleOlderThan20.forEach(person -> System.out.println(person.toString()));

    }
}
