package homeworkTask2;

public class Secretary extends Person{
    public Secretary(Name name, Age age) {
        super(name, age);
    }
    public Secretary (Person person)
    {
        super(person.name, person.age);
    }

    @Override
    public boolean interview() {
        return super.interview();
    }
}
