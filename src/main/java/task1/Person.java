package task1;

public class Person {

    Name name;
    BirthDate birthDate;


    public Person(String name, int day, int month, int year) {
        birthDate = new BirthDate(day, month, year);
        // TODO: 15.07.2020 implement
    }

    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public boolean isOlderThan(Person person) {
        return this.birthDate.earlyThan(person.birthDate);
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}
