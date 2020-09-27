package homeworkTask2;

public class Jurist extends Person {
    public Jurist(Name name, Age age) {
        super(name, age);
    }

    public Jurist(Person person) {
        super(person.name, person.age);
    }

    @Override
    public boolean interview() {
        return super.interview();
    }
}
