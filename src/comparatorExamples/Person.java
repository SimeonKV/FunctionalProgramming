package comparatorExamples;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int ageDifference(Person anotherPerson){
        return age - anotherPerson.getAge();
    }

    @Override
    public String toString(){
        return String.format("%s - %d",name,age);
    }
}
