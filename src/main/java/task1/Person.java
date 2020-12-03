package task1;



public class Person implements HasAge {

    Name name;
    BirthDate birthDate;


    public Person() {
        name = new Name();
        birthDate = new BirthDate(2020);
    }

    public Person(Name name, BirthDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public BirthDate getBd() {
        return birthDate;
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}
