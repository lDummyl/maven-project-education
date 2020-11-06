package task1;

import task2.*;

import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);


    public Collection<SecretaryImpl> generateSecretaries(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<SecretaryImpl, ?, List<SecretaryImpl>> collector = Collectors.toList();

        Function<Person, SecretaryImpl> perToCand = SecretaryImpl::new;

        return people.stream().map(perToCand).collect(collector);
    }

    public Collection<Security> generateSecurity(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<Security, ?, List<Security>> collector = Collectors.toList();

        Function<Person, Security> perToCand = Security::new;

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
}
