package task2;

import task1.BirthDate;
import task1.Person;

import javax.crypto.spec.PSource;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;


public class Director extends Person implements MailSender {

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

    public void makeChoiceAsPleasantDirector() {
        HashSet<Person> set = (HashSet<Person>) new Hr("").selectedPeople(maxQuantityOfStuff);
        System.out.println(set + "\n");
    }


    public void makeChoiceAsBadDirector() {
        HashSet<Person> set = (HashSet<Person>) new Hr("").selectedPeople(maxQuantityOfStuff);
        boolean b = true;
        while (b) {
            set = (HashSet<Person>) new Hr("").selectedPeople(maxQuantityOfStuff);
            INNER_LOOP: for (Person person : set) {
                b = person.birthDate.year<1970?true:false;
                if(b==false){
                    continue;
                }else {
                    System.out.println("I don't need old candidates! Fetch me a new list!");
                    break INNER_LOOP;
                }
            }
        }
        System.out.println(set + "\n");
    }

//        boolean b = true;
//
//            b = person.birthDate.year < 1970 ? true : false;
//            if (b == false) {
//                System.out.println("I don't need old candidates! Fetch me a new list!");
//                makeChoiceAsBadDirector();
//            }
//        }
//        System.out.println(set + "\n");
    }

