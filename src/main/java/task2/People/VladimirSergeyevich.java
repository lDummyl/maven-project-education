package task2.People;

import task2.Gender;
import task2.Person;
import task2.Skills.CanPassInterview;

public class VladimirSergeyevich extends Person implements CanPassInterview {
    public VladimirSergeyevich(String name, int age, Gender gender) {
        super(name, age, gender);
    }
}
