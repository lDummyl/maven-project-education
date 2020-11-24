package task2;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHr implements Hr {
    Collection<SecretaryImpl> secCandidates;
    Map<Class<?>, List<Worker>> candidates = new HashMap<>();


    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {
        SecretaryImpl secretary = (SecretaryImpl) candidate;
        int expectedAge = 30;
        if (secretary.age.getYears() < expectedAge) {
            secCandidates.add(secretary);
        }
        return secCandidates;
    }

    // TODO: 24.11.2020 Доделать перенос интервью Hr
    // TODO: 11/16/20  да, это норма! А вот Unchecked cast это то что делать не стоит так жк как и проверять через instanceof,
    //  но с этим у тебя все получится.
    // С дженериком вроде выглядит красивее
    public<T extends Worker> void addCandidate(T candidate) {
        Class<? extends Worker> aClass = candidate.getClass();

        List<T> workers = new ArrayList<>();

        workers.add(candidate);
    }

    @Override
    public Map<Class<?>, List<Worker>> getCandidates() {
        return this.candidates;
    }
}