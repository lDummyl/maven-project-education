package CollectionWork;

import java.util.Objects;

public class Human implements Comparable<Human> {
    BirtDate birthDate;
    int age;
    static int i = 0;

    public Human() {
        this.birthDate = new BirtDate();
        System.out.println("Создан человек " + Human.i);
        Human.i++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human person = (Human) o;
        return age == person.age &&
                Objects.equals(birthDate, person.birthDate);
    }


    @Override
    public int hashCode() {
        return Objects.hash(birthDate, age);
    }


    @Override
    public int compareTo(Human o) {
        return this.birthDate.compareTo(o.birthDate);
    }
}
