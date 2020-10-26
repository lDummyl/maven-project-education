package task2;

import task1.Person;

import java.time.LocalDate;

public class CanditateSecretary extends Person implements Secretary{
    Integer age = 0;


    public CanditateSecretary(Person person) {
        super(person.getName(),person.getBirthDate());
        this.age = LocalDate.now().getYear()-this.getBirthDate().getLocalBirthDate().getYear();
        System.out.println(this.getBirthDate().getLocalBirthDate().getYear());
        System.out.println(this.age);
    }




    @Override
    public void sayHelloTo(Object o) {

    }
}
