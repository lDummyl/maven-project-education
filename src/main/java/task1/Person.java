package task1;



public class Person implements HasAge {

    Name name;
    BirthDate birthDate;


    public Person() {
        name = new Name();
        birthDate = new BirthDate(2020);
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
