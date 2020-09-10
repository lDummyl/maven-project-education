package homeworkTask2;

public class Person {
    Name name;
    Age age;
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
