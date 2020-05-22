package task2;

import java.time.LocalDate;
import java.util.Objects;

// TODO: 5/21/20 никто не запрещает переиспользовать уже созданные классы, наоборот это крайне приветствуется
public class Person {

    public Name name;
    public BirthDate birthDate;

    public Person(Name name, BirthDate age) {
        this.name =  name;
        this.birthDate = age;
    }


    @Override
    public String toString() {
        return  "name=" + name +
                ", birthDate=" + birthDate;
    }
}
