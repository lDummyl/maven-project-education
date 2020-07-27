package task2;

import task1.BirthDate;
import task1.Name;
import task1.Person;

// TODO: 7/27/20 используй наследование от Person и не тащи что у тебя уже есть, доступ между пекеджами прекрасно работает
public class Secretary extends Person {

    public Secretary(Name name, BirthDate birthDate) {
        super(name, birthDate);
    }
}
