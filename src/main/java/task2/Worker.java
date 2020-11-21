package task2;

import task1.CandidateProvider;
import task1.Person;

import java.time.Period;
import java.util.Random;

public abstract class Worker extends Person {
    public Integer experience;
    public Period possibleExperience;

    public Worker(Person person) {
        Random random = new Random();
        this.birthDate = person.birthDate;
        this.name = person.name;
        this.age = person.age;

        try {
            this.experience = this.getExperience();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(experience);
    }


    public int compareTo(Worker o) {
        return Integer.compare(this.age.getYears(), o.age.getYears()) * 2 + this.experience.compareTo(o.experience);
    }

    public Integer getExperience() {
        Random random = new Random();
        Integer possibleExperience;
        possibleExperience = this.age.getYears() - CandidateProvider.adultAge.getYears();
        //System.out.println(possibleExperience);
        if (possibleExperience >= 1) {
            return random.nextInt(possibleExperience);
        } else if (possibleExperience == 0) {
            return 0;
        } else {
            throw new IllegalStateException("Wrong Date");
        }
    }

    // TODO: 11/16/2020 Сделал метод абстрактным, чтобы требовалась реализация
    public abstract boolean passInterview();
}

