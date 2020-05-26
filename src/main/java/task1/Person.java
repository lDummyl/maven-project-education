package task1;

public class Person {
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public Name name;
    public Age age;

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }

    public boolean isOlderThan(Person oldest) {
//		oldest 1900 this 1990
        // TODO: 5/18/20 if не нужен в таком случае сработает так return !oldest.age.year < age.year или так return oldest.age.year >= age.year

        return oldest.age.year >= age.year;

    }
}
