package task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

public class Person {
    static LocalDate oldestDate = LocalDate.now();
    static Person oldest = null;
    Name name;
    BirthDate birthDate;
    static ArrayList<Person> persons = new ArrayList<>();

    public Person(String name, BirthDate localbirthDate) {
        this.name = new Name(name);
        this.birthDate = localbirthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();

        if (!hasPerson(this)) {
            persons.add(this);
            if (this.birthDate.localBirthDate.isBefore(oldestDate)) {
                oldestDate = this.birthDate.localBirthDate;
                oldest = this;
                //System.out.println("Добален человек");
            }
        }
    }

    public boolean hasPerson(Person p) {
        ListIterator<Person> iterator = persons.listIterator();
        while (iterator.hasNext()) {
            if (p.equals(iterator.next())) {
                System.out.println("Такой человек уже есть");
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        if (this.name.firstName.equals(person.name.firstName) && this.name.lastName.equals(person.name.lastName) && this.birthDate.localBirthDate.equals(person.birthDate.localBirthDate))
            return true;

        return false;
    }
}



