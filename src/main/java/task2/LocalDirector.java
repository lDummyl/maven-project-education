package task2;

import java.util.*;

public class LocalDirector implements Director {
    int enoughCandidates;
    Random random = new Random();


    public LocalDirector() {
        enoughCandidates = 100;
    }

    public LocalDirector(int enaughtCAndidate) {
        this.enoughCandidates = enaughtCAndidate;
    }

    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {

        if (candidates.size() >= enoughCandidates) {
            ArrayList<SecretaryImpl> secretaries = new ArrayList<>(candidates);
            return secretaries.get(random.nextInt(secretaries.size() / 2));
        } else {
            throw new IllegalStateException("Not enough candidates");
        }
    }

    public <T extends Worker> Optional<T> chooseWorker(Map<Class<?>, List<Worker>> candidates, Class<T> candidateClass) {
        List<Worker> workers = candidates.get(candidateClass);
        if (workers == null || workers.size() < enoughCandidates) {
            return Optional.empty();
        }
        Worker selectedCandidate = workers.get(random.nextInt(workers.size()));
        if (!selectedCandidate.getClass().equals(candidateClass)){
            throw new IllegalArgumentException("Класс не соответствует ключу");
        }
        return Optional.of(candidateClass.cast(selectedCandidate));
    }
}






