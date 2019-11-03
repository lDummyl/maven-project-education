package task2.People;

import task2.Gender;
import task2.Person;
import task2.Skills.CanPassInterview;

public class SergeyPetrovich extends Person implements CanPassInterview {
    public SergeyPetrovich(String name, int age, Gender gender) {
        super(name, age, gender);
    }
}
