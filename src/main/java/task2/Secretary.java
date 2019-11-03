package task2;

import task2.Skills.CanPassInterview;

public class Secretary implements CanPassInterview {

    // TODO: 10/31/19 Есть хороший принцип yagni почитай про него. Это конечно тренеровочная площадка, но тренеровать и этот принцип тоже желательно
    //  пока задача секретаря уметь проходить интервью.

    // TODO: 10/25/19 хочешь сказать что аггрегация лучше наследвания? Справедливо, но еще лучше интерфейсы.

    private String name;
    private int age;
    private Gender gender; // TODO: 11/3/19 используй для таких вещей enum
    private Office office;

    public Secretary(Person person) {
        this.name = person.getName();
        this.age = person.getAge();
        this.gender = person.getGender();
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    protected void setOffice(Office office) {
        this.office = office;
    }
}
