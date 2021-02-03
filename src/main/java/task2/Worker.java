package task2;

import task1.CandidateProvider;
import task1.Person;

import java.time.Period;
import java.util.Random;

public abstract class Worker extends Person {
    public Integer experience;
    Random random = new Random();

    public Worker(Person person) {
        Random random = new Random();
        this.setBirthDate(person.getBirthDate());
        this.setName(person.getName());
        this.setAge(person.getAge());

        try {
            this.experience = this.getExperience();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(experience);
    }


    public int compareTo(Worker o) {
        return Integer.compare(this.getAge().getYears(), o.getAge().getYears()) * 2 + this.experience.compareTo(o.experience);
    }

    public Integer getExperience() {

        Integer possibleExperience;
        possibleExperience = this.getAge().getYears() - CandidateProvider.adultAge.getYears();
        if (possibleExperience >= 1) {
            return random.nextInt(possibleExperience);
        } else if (possibleExperience == 0) {
            return 0;
        } else {
            throw new IllegalStateException("Wrong Date");
        }
    }


    public abstract boolean passInterview();
}

