package task1;

public class Person {

    public Name name;
    public Age age;

    public Person(){

    }

    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
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
