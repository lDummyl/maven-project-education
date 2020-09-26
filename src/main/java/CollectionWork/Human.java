package CollectionWork;

import java.util.Objects;

public class Human {
    BirtDate birthDate;
    int age;
    //static int i = 0;
    int health;
    int level;

    public Human() {
        this.birthDate = new BirtDate();
        //System.out.println("Создан человек " + Human.i);
        //Human.i++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human person = (Human) o;
        return Objects.equals(birthDate, person.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthDate, age);
    }
}
