package task2;

import task1.Person;
import task1.PersonProvider;

import java.util.Set;

public class Universe {

    public static void main(String[] args) {
        Office apple = new Office();
        apple.director = new Director("Steve Jobs");
//        hr
        PersonProvider personProvider = new PersonProvider();
        Set<? extends Person> secretaries = personProvider.getSecretaries(10);
        for (Person person : secretaries) {
            apple.invitePeople(person);
        }
        boolean b = apple.secretary == null;
        System.out.println("b = " + b);

//        apple.hr =


    }
}
