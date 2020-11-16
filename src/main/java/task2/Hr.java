package task2;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface Hr {
    Collection<SecretaryImpl> addSecretaryCandidate(Object candidate);
    public void addCandidate(Object candidate);
    public Map<Class<?>, List<Worker>> getCandidates();
    //Для удобства расширил интерфейл // возможно так не стоит делать
}
