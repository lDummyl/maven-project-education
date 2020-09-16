package homeworkTask2;

public class Accountant extends Person {
    public Accountant(Name name, Age age) {
        super(name, age);
    }
    public Accountant (Person person)
    {
        super(person.name, person.age);
    }
    @Override
    public boolean interview() {
        return super.interview();
    }
}
