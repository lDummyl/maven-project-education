package task1;

import lombok.*;

import java.time.LocalDate;
import java.time.Period;

@Generated
@Setter
@Getter
@EqualsAndHashCode
public class Person implements Comparable<Person> {
    private Name name;
    private BirthDate birthDate;
    private Period age;

    public Person(String name, BirthDate localBirthDate) {
        this.name = new Name(name);
        this.birthDate = localBirthDate;
    }


    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public Person() {
        this.name = new Name();
        this.birthDate = new BirthDate();
        this.age = Period.between(birthDate.getLocalBirthDate(), LocalDate.now());
    }


    @Override
    public int compareTo(Person o) {
        return this.birthDate.compareTo(o.birthDate);
    }
}



