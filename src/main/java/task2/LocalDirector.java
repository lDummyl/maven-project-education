package task2;

import task1.Person;

import java.util.*;
import java.util.stream.Collectors;

public class LocalDirector implements Director {
    int enaughtCAndidate;
    Random random = new Random();
    ;

    public LocalDirector() {
        enaughtCAndidate = 100;
    }

    public LocalDirector(int enaughtCAndidate) {
        this.enaughtCAndidate = enaughtCAndidate;
    }

    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {


        if (candidates.size() >= enaughtCAndidate) {
            ArrayList<SecretaryImpl> secretaries = new ArrayList<>(candidates);
            return secretaries.get(random.nextInt(secretaries.size() / 2));
        } else {
            throw new IllegalStateException("Not enough candidates");
        }
    }

    // TODO: 24.11.2020  теперь должен возвращатся класс нужного типа
    public <T extends Worker> Optional<T> chooseWorker(Map<Class<?>, List<Worker>> candidates, Class<T> candidateClass) {
        List<Worker> workers = candidates.get(candidateClass);
        if (workers == null || workers.size() < enaughtCAndidate) {
            return Optional.empty();
        }
        Worker selectedCandidate = workers.get(random.nextInt(workers.size()));
        if (!selectedCandidate.getClass().equals(candidateClass)){
            throw new IllegalArgumentException("Класс не соответствует ключу");
        }
        return Optional.of(candidateClass.cast(selectedCandidate));
    }
}






