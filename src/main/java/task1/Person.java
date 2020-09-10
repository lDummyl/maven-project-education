package task1;

import java.time.LocalDate;

public class Person {
    static LocalDate oldestDate = LocalDate.now();
    static Person oldest = null;
    Name name;
    BirthDate birthDate;

    public Person(String name, BirthDate localbirthDate) {
        this.name = new Name(name);
        this.birthDate = localbirthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
        System.out.println(this);

        if (this.birthDate.localBirthDate.isBefore(oldestDate)) {
            oldestDate = this.birthDate.localBirthDate;
            oldest = this;
        }
    }
}
