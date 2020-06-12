package task2;

import task1.BirthDate;
import task1.Person;

import java.util.*;


public class Director extends Person implements MailSender {

    private Office officeImIn;
    int enoughCandidatesToDecide = 3;

    String name;


    public Director(String name) {
        super(null, new BirthDate());
        this.name = name;
    }

    public Director(String name, Office office) {
        this(name);
        officeImIn = office;
    }


    @Override
    public void sendMail(Mail mail) {
        officeImIn.secretary.sendMail(mail);
    }



    public void makeChoice(Set<Secretary> candidates) {
        if (candidates.size() >= enoughCandidatesToDecide) {
            Secretary secretary = candidates.iterator().next();
            officeImIn.secretary = secretary;
        } else {
            System.out.println("Wat kind of candidates you gived me!" + officeImIn.hr.name);
        }

    }


}

