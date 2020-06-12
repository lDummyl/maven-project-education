package task2;

import task1.BirthDate;
import task1.Name;
import task1.Person;


public class Secretary extends Person implements MailSender {

    public Secretary(Name name, BirthDate age) {
        super(name, age);
    }

    @Override
    public void sendMail(Mail mail) {
        System.out.println(mail + "Sent!");
    }



}

