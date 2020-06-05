package task2;

import task1.BirthDate;
import task1.Person;

import java.util.HashSet;


public class Director extends Person implements MailSender,makeDecision {

    private Office officeImIn;

    String name;

    public Director(String name, int maxQuantityOfStuff) {
        super(null, new BirthDate());
        this.name = name;
        this.maxQuantityOfStuff = maxQuantityOfStuff;
    }

    int maxQuantityOfStuff;

    public Director(String name) {
        super(null, new BirthDate());
    }

    public Director(String name, Office office) {
        this(name);
        officeImIn = office;
    }



    // TODO: 5/22/20 не и спользуй статические методы


    // TODO: 5/24/20 точка запуска должна быть одна в задаче, если хочешь протестировать переноси в тесты
    public static void main(String[] args) {

    }


    @Override
    public void sendMail(Mail mail) {
        officeImIn.secretary.sendMail(mail);
    }

    @Override
    public HashSet<Person> makeChoice(Person person) {
        return null;
    }
}
