package homeworkTask2;

import java.util.Random;

public class Person {
    Name name;
    Age age;
    public Person(Name name, Age age) {
        this.name = name;
        this.age = age;
    }

    public boolean interview ()
    {
        Random random = new Random();
        return random.nextInt(100) > 50;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
