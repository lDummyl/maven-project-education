package task2;

public class Person {

    public Name name;
    public BirthDate birthDate;

    public Person(Object name, Object age) {
        this.name = (Name) name;
        this.birthDate = (BirthDate) age;
    }

    @Override
    public String toString() {
        return "firstName='" + name.firstName + '\'' +
                ", lastName='" + name.lastName;
    }

}
