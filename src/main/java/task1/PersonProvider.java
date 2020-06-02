package task1;

import task2.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonProvider {

    static List<String> firstN = new ArrayList<>();
    static Random random = new Random();
    static List<String> lastN = new ArrayList<>();

    static {
        firstN.add("Ivan");
        firstN.add("Oleg");
        firstN.add("Nikita");
        firstN.add("Roman");
        firstN.add("Nikolay");
        firstN.add("Dmitry");
        firstN.add("Alexander");
        firstN.add("Stanislav");
        firstN.add("Konstantin");
        firstN.add("Sergey");
    }

    static {
        lastN.add("Ivanov");
        lastN.add("Smirnov");
        lastN.add("Sidorov");
        lastN.add("Petrov");
        lastN.add("Vodkin");
        lastN.add("Nikitin");
        lastN.add("Orlov");
        lastN.add("Kruglov");
        lastN.add("Jiglov");
        lastN.add("Djigurda");
    }


    public Person getSomePerson() {
        return new Person(new Name(firstN.get(random.nextInt(firstN.size())), lastN.get(random.nextInt(lastN.size()))),
                new Age(random.nextInt(30) + 1, random.nextInt(12) + 1, random.nextInt(80) + 1940));
    }

    public List<Person> getSomePerson(int qty) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < qty; i++) {
            list.add(getSomePerson());
        }
        return list;
    }

    public Director getSomeDirector(){
        return new Director(getSomePerson());
    }

    public Hr getSomeHr(){
        return new Hr(getSomePerson());
    }

    public List<Secretary> getSomeSecretaries(int qty) {
        List<Person> somePerson = getSomePerson(qty);
        List<Secretary> secretaries = new ArrayList<>();
        for (Person person : somePerson) {
            secretaries.add(new Secretary(person));
        }
        return secretaries;
    }

    public List<Security> getSomeSecurities(int qty) {
        List<Person> somePerson = getSomePerson(qty);
        List<Security> securities = new ArrayList<>();
        for (Person person : somePerson) {
            securities.add(new Security(person));
        }
        return securities;
    }

    public List<Jurist> getSomeJurists(int qty) {
        List<Person> somePerson = getSomePerson(qty);
        List<Jurist> jurists = new ArrayList<>();
        for (Person person : somePerson) {
            jurists.add(new Jurist(person));
        }
        return jurists;
    }

    public List<Accountant> getSomeAccountants(int qty) {
        List<Person> somePerson = getSomePerson(qty);
        List<Accountant> accountants = new ArrayList<>();
        for (Person person : somePerson) {
            accountants.add(new Accountant(person));
        }
        return accountants;
    }

    // TODO: 5/26/20 вот тебе бонус с примененеием черной магии, но работать он будет не сразу, нужно понять чего и где не хватает.
    public <T extends OfficeWorker> List<T> getSomeOf(Class<T> clazz, int qty) throws Exception {
        List<Person> somePerson = new PersonProvider().getSomePerson(qty);
        List<T> list = new ArrayList<>();
        for (Person person : somePerson) {
            Constructor<T> constructor = clazz.getConstructor(Person.class);
            T t = constructor.newInstance(person);
            list.add(t);
        }
        return list;
    }
    // TODO: 5/26/20 вот тебе бонус с примененеием черной магии, но работать он будет не сразу, нужно понять чего и где не хватает.
    public List<OfficeWorker> getSomeOfNoGen(Class<?> clazz, int qty) throws Exception {
        List<Person> somePerson = new PersonProvider().getSomePerson(qty);
        List<OfficeWorker> list = new ArrayList<>();
        for (Person person : somePerson) {
            Constructor<?> constructor = clazz.getConstructor(Person.class);
            OfficeWorker t =(OfficeWorker) constructor.newInstance(person);
            list.add(t);
            addSecurityInit(clazz, t);
        }

        return list;
    }

    private void addSecurityInit(Class<?> clazz, OfficeWorker t) {
        if (clazz.equals(Security.class)){
            Security security = (Security) t;
            security.pal = new Security(new Person());
        }
    }

    public static void main(String[] args) throws Exception{
        PersonProvider personProvider = new PersonProvider();
//        List<Security> securities = personProvider.getSomeOf(Office.class, 10);
//        for (Security security : securities) {
//            System.out.println(security.getClass());
//        }
        List<OfficeWorker> someOfNoGen = personProvider.getSomeOfNoGen(Age.class, 10);
        for (OfficeWorker officeWorker : someOfNoGen) {
            System.out.println(officeWorker.getClass());
        }


    }
}
