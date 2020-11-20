package task1;


import java.util.List;


public class Main {

    public static void main(String[] args) {
        Provider<Dino> provider = Dino::new;
        Dino oldest = generateAndFind(provider);
        oldest.scream();

        Provider<Person> providerPerson = Person::new;
        Person oldPerson = generateAndFind(providerPerson);
        System.out.println("oldPerson.name.lastName = " + oldPerson.name.lastName);

        HasAge futureGuest = () -> new BirthDate(5_000);
        Provider<HasAge> futurePortal = () -> futureGuest;
        HasAge guest = generateAndFind(futurePortal);
        System.out.println("guest.getBd().year = " + guest.getBd().year);
    }

    private static <T extends HasAge> T generateAndFind(Provider<T> provider) {
        List<T> peoples = provider.provide(100);
        return HasAge.getOldest(peoples);
    }

}

