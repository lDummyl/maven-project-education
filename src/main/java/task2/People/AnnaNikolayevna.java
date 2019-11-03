package task2.People;

import task2.Gender;
import task2.Person;
import task2.Skills.CanPassInterview;

public class AnnaNikolayevna extends Person implements CanPassInterview {
    public AnnaNikolayevna(String name, int age, Gender gender) {
        super(name, age, gender);
    }
}
