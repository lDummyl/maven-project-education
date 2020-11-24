package task2;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Director  {

    SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates);

    public<T extends Worker> T chooseWorker(Map<Class<?>, List<T>> candidates, Class<?> candidateClass);
}
