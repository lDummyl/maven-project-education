package task2;

import task2.Skills.CanPassInterview;

public class Secretary implements CanPassInterview {

    // TODO: 10/31/19 Есть хороший принцип yagni почитай про него. Это конечно тренеровочная площадка, но тренеровать и этот принцип тоже желательно
    //  пока задача секретаря уметь проходить интервью.

    // TODO: 10/25/19 хочешь сказать что аггрегация лучше наследвания? Справедливо, но еще лучше интерфейсы.

    private String name;
    private int age;
    private boolean sex;

    public Secretary(Person person) {
        this.name = person.getName();
        this.age = person.getAge();
        this.sex = person.getSex().equalsIgnoreCase("female");
    }
}
