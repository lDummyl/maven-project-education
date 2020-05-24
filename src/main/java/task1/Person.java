package task1;

public class Person {

    Name name;
    Age age;

    Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Person() {

    }

    public Name getName() {
        return name;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
