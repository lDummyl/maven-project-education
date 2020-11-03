package task1;

import task2.SecretaryImpl;
import task2.Worker;

import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);

    public Collection<Worker> generateCandidate(int numberOfCandidate, Class<SecretaryImpl> clazz) {
        throw new IllegalStateException();
//        PersonsProvider personsProvider = new PersonsProvider();
//
//        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
//        Collector<SecretaryImpl, ?, List<Worker>> collector = Collectors.toList();
//
//        Function<Person, SecretaryImpl> perToCand = SecretaryImpl::new;
//
//        return people.stream().map(perToCand).collect(collector);
    }

    public Collection<SecretaryImpl> generateSecretaries(int numberOfCandidate) {
        PersonsProvider personsProvider = new PersonsProvider();

        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        Collector<SecretaryImpl, ?, List<SecretaryImpl>> collector = Collectors.toList();

        Function<Person, SecretaryImpl> perToCand = SecretaryImpl::new;

        return people.stream().map(perToCand).collect(collector);
    }

}
