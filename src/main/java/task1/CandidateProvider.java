package task1;

import task2.*;

import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);



    public static void main(String[] args) {
        Function<Person, SecretaryImpl> function = new Function<Person, SecretaryImpl>() {
            @Override
            public SecretaryImpl apply(Person person) {
                return new SecretaryImpl(person);
            }
        };

        Function<Person, SecretaryImpl> function2 = secr -> {
            return new SecretaryImpl(secr);
        };

        Function<Person, SecretaryImpl> function1 = secr -> new SecretaryImpl(secr);

        Function<Person, SecretaryImpl> function3 = SecretaryImpl::new;

        CandidateProvider candidateProvider = new CandidateProvider();
        Collection<SecretaryImpl> secretaries = candidateProvider.generateAnyWorkers(100, function);
        System.out.println(secretaries);
    }
    public Collection<SecretaryImpl> generateSecretaries(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<SecretaryImpl, ?, List<SecretaryImpl>> collector = Collectors.toList();

        Function<Person, SecretaryImpl> perToCand = SecretaryImpl::new;


        return people.stream().map(perToCand).collect(collector);
    }
    public <T extends Worker> List<T> generateAnyWorkers(int numberOfCandidate, Function<Person, T> constructorRef) {

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        return people.stream().map(constructorRef).collect(Collectors.toList());
    }

    public Collection<Guard> generateSecurity(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<Guard, ?, List<Guard>> collector = Collectors.toList();

        Function<Person, Guard> perToCand = Guard::new;

        return people.stream().map(perToCand).collect(collector);
    }

    public Collection<Lawyer> generateLawer(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<Lawyer, ?, List<Lawyer>> collector = Collectors.toList();

        Function<Person, Lawyer> perToCand = Lawyer::new;

        return people.stream().map(perToCand).collect(collector);
    }

    public Collection<Manager> generateManager(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<Manager, ?, List<Manager>> collector = Collectors.toList();

        Function<Person, Manager> perToCand = Manager::new;

        return people.stream().map(perToCand).collect(collector);
    }

    PersonsProvider personsProvider = new PersonsProvider();
    // TODO: 13.11.2020 вот как 4 строки заменяют 44 и до бесконечности
    public <T extends Worker>/*тут задаем ограничение что работать только с тем Т который от Worker*/ Collection<T> generateAny(int qty, Function<Person, T> /*отсюда узнаем что будет в качестве T*/function) {
        TreeSet<Person> people = personsProvider.generateAdultPersons(qty);
        return people.stream().map(function).collect(Collectors.toList());
    }


    /*public static void main(String[] args) {

        CandidateProvider candidateProvider = new CandidateProvider();
        // TODO: 13.11.2020 вуоля
        Collection<SecretaryImpl> secretaries = candidateProvider.generateAny(100, SecretaryImpl::new);
        Collection<Lawyer> lawyers = candidateProvider.generateAny(100, Lawyer::new);
    }*/


}
