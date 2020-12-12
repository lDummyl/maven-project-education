package task2;


import java.util.*;


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
        Class<? extends Worker> workerClass = candidate.getClass();
        List<Worker> workers = candidates.get(workerClass);
        
        if (workers != null) {
            workers.add(candidate);
        } else {
            ArrayList<Worker> workersNew = new ArrayList<>();
            workersNew.add(candidate);
            candidates.put(workerClass, workersNew);
        }
    }


    @Override
    public Map<Class<?>, List<Worker>> getCandidates() {
        return this.candidates;
    }
}