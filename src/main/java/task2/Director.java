package task2;

import task2.workers.SecretaryImpl;
import task2.workers.Worker;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Director  {

    SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates);

    public <T extends Worker> Optional<T> chooseWorker(Map<Class<?>, List<Worker>> candidates, Class<T> candidateClass);
}
