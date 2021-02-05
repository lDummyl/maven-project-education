package task2;

import task2.workers.SecretaryImpl;
import task2.workers.Worker;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface Hr {
    Collection<SecretaryImpl> addSecretaryCandidate(Object candidate);
    public void addCandidate(Object candidate);
    public Map<Class<?>, List<Worker>> getCandidates();
    public <T extends Worker> void addCandidateDet(T candidate);
}
