package task1;


public class Main {

    public static void main(String[] args) {

        first();
        second();

    }

    public static void first() {
        PersonsProvider personsProvider = new PersonsProvider();
        personsProvider.generatePersons(5);
    }

    public static void second() {
        PersonsProvider personsProvider = new PersonsProvider();
        personsProvider.generatePersons(1000);
    }
}

