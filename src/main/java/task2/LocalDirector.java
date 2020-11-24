package task2;

import java.util.*;
import java.util.stream.Collectors;

public class LocalDirector implements Director {
    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {
        int expectedCandidates = 100;
        Random random = new Random();

        if (candidates.size() >= expectedCandidates) {
            ArrayList<SecretaryImpl> secretaries = new ArrayList<>(candidates);
            return secretaries.get(random.nextInt(secretaries.size() / 2));
        } else {
            throw new IllegalStateException("Not enough candidates");
        }
    }

    // TODO: 24.11.2020  теперь должен возвращатся класс нужного типа
    public<T extends Worker> T chooseWorker(Map<Class<?>, List<T>> candidates, Class<?> candidateClass) {

        int neededCandiadates = 100;
        Random random = new Random();
        List<T> workers = candidates.get(candidateClass);
        List<T> candidatesWorkers;

        if (workers == null) {
            throw new NullPointerException("Пустой список кандидатов");
        } else {
            candidatesWorkers = workers.stream().filter(T::passInterview).collect(Collectors.toList());
        }

        if (candidatesWorkers.size() == 0) {
            throw new IllegalArgumentException("Нету кандидатов прошедших интервью");
        }

        if (candidatesWorkers.size() < neededCandiadates) {
            throw new IllegalArgumentException("Недостаточно кандидатов");
        } else {
            return candidatesWorkers.get(random.nextInt(candidatesWorkers.size()));
        }
    }
}






