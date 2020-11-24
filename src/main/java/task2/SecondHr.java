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
    public void addCandidate(Object candidate) {
        Class<?> candidateClass = candidate.getClass();
        if (!(candidate instanceof Worker)) {
            throw new IllegalStateException("Wrong object");
        }
        List<Worker> workers = candidates.get(candidateClass);
        if (workers != null) {
            workers.add((Worker) candidate);
        } else {

            if (workers == null) {
                throw new NullPointerException("Пустой список кандидатов");
            } else {
                List<Worker> candidates = workers.stream().filter(Worker::passInterview).collect(Collectors.toList());
            }
            candidates.put(candidateClass, (List<Worker>) candidates);
        }
    }

    @Override
    public Map<Class<?>, List<Worker>> getCandidates() {
        return this.candidates;
    }
}