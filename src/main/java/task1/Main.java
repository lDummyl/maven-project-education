package task1;


import java.util.List;
import java.util.Random;


public class Main {

    public static void main(String[] args) {
        try {
            Provider provider = Dino::new;
            Dino oldest = (Dino) generateAndFind(provider);
            oldest.scream();

            Provider providerPerson = Person::new;
            Person oldPerson = (Person) generateAndFind(providerPerson);
            System.out.println("oldPerson.name.lastName = " + oldPerson.name.lastName);

            HasAge futureGuest = () -> new BirthDate(5_000);
            Provider futurePortal = () -> futureGuest;
            HasAge guest = generateAndFind(futurePortal);
            System.out.println("guest.getBd().year = " + guest.getBd().year);
        } catch (Exception e) {
        }
    }

    private static HasAge generateAndFind(Provider provider) {
        List<HasAge> peoples = provider.provide(100);
        if(new Random().nextBoolean()){
            return new Person();
        }
        return HasAge.getOldest(peoples);
    }

}

