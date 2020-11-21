package task1;

import task2.*;

import java.time.Period;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class CandidateProvider {
    public static final Period adultAge = Period.ofYears(18);



   /* public static void main(String[] args) {
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
    }*/

    public <T extends Worker> List<T> generateAnyWorkers(int numberOfCandidate, Function<Person, T> constructorRef) {
        PersonsProvider personsProvider = new PersonsProvider();
        TreeSet<Person> people = personsProvider.generateAdultPersons(numberOfCandidate);
        return people.stream().map(constructorRef).collect(Collectors.toList());
    }
    
   /* PersonsProvider personsProvider = new PersonsProvider();
    // TODO: 13.11.2020 вот как 4 строки заменяют 44 и до бесконечности
    public <T extends Worker>*//*тут задаем ограничение что работать только с тем Т который от Worker*//* Collection<T> generateAny(int qty, Function<Person, T> *//*отсюда узнаем что будет в качестве T*//*function) {
        TreeSet<Person> people = personsProvider.generateAdultPersons(qty);
        return people.stream().map(function).collect(Collectors.toList());
    }*/




}
