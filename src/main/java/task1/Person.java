package task1;

public class Person {

    Name name;
    BirthDate birthDate;

    public Person(Name name, BirthDate age) {
        // TODO: 5/21/20 o_0 !?!
        this.name = name;
        this.birthDate = age;
    }


    @Override
    public String toString() {
        return "firstName='" + name.firstName + '\'' +
                ", lastName='" + name.lastName + '\'' +
                ", age=" + birthDate.year + " " + birthDate.month + " " + birthDate.day + '\'';
    }


    public boolean isYounferThan(Person person) {
        return this.birthDate.toLocalDate().isAfter(person.birthDate.toLocalDate());
    }
}
