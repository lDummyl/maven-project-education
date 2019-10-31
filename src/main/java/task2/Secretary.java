package task2;

import task2.Skills.AnswerThePhone;
import task2.Skills.CanMakeCoffee;
import task2.Skills.DocumentArchiving;

public class Secretary implements AnswerThePhone, CanMakeCoffee, DocumentArchiving {

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
