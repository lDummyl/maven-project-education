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

    // TODO: 22.11.2020 проверить метод (для себя)
    public Worker chooseWorker(Map<Class<?>, List<Worker>> candidates,  Class<? extends Worker> candidateClass) {
        Random random = new Random();
        List<Worker> workers = candidates.get(candidateClass);
        List<Worker> candidatesWorkers = workers.stream().filter(Worker::passInterview).collect(Collectors.toList());

        return candidatesWorkers.get(random.nextInt(candidatesWorkers.size()));
    }
}






