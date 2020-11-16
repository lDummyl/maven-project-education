package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class SecondHr implements Hr {
    Collection<SecretaryImpl> secCandidates;
    Map<Class<?>, List<Worker>> candidates;

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {
        SecretaryImpl secretary = (SecretaryImpl) candidate;
        int expectedAge = 30;
        if (secretary.age.getYears() < expectedAge) {
            secCandidates.add(secretary);
        }
        return secCandidates;
    }

    // TODO: 11/16/2020 Стоит ли так разделять методы? То есть которые вносит изменения void, а который возвращает данные return
    // TODO: 11/16/20  да, это норма! А вот Unchecked cast это то что делать не стоит так жк как и проверять через instanceof,
    //  но с этим у тебя все получится.
    public void addCandidate(Object candidate) {
        if (Worker.class.isAssignableFrom(candidate.getClass())) {
            candidates.put(candidate.getClass(), (List<Worker>) candidate);
        }


    }

    @Override
    public Map<Class<?>, List<Worker>> getCandidates() {
        return this.candidates;
    }
}