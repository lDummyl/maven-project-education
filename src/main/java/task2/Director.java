package task2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Director  {

    SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates);

    public Worker chooseWorker(Map<Class<?>, List<Worker>> candidates,  Class<? extends Worker> candidateClass);
}
