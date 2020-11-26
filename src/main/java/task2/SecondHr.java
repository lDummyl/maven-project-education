package task2;

import lombok.var;

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

    @Override
    public void addCandidate(Object candidate) {

    }

    public <T extends Worker> void addCandidateDet(T candidate) {
        if (!candidate.passInterview()) {
            return;
        }
        Class<? extends Worker> aClass = candidate.getClass();
        List<Worker> workers = candidates.get(aClass);
        if (workers != null) {
            workers.add(candidate);
        } else {
            ArrayList<Worker> workersNew = new ArrayList<>();
            workersNew.add(candidate);
            candidates.put(aClass, workersNew);
        }
    }


    @Override
    public Map<Class<?>, List<Worker>> getCandidates() {
        return this.candidates;
    }

    public <T extends Worker> List<T> getPureCandList(Class<T> candidateClass) {


        List<Worker> workers = this.candidates.get(candidateClass);
        List<Worker> relevantWorkers = workers.stream().filter(Worker::passInterview).collect(Collectors.toList());
        return null;
    }


}