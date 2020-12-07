package task1;

import task2.*;

import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);

    public <T extends Worker> List<T> generateAnyWorkers(int numberOfCandidate, Function<Person, T> constructorRef) {
        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        return people.stream().map(constructorRef).collect(Collectors.toList());
    }
}
