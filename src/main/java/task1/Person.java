package task1;

public class  Person {

    Main.Name name;
    Main.BirthDate birthDate;

    public Person(Object name, Object age) {
        // TODO: 5/21/20 o_0 !?!
        name = this.name;
         age = this.birthDate;
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
