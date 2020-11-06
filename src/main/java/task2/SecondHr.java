package task2;

import java.util.ArrayList;
import java.util.Collection;

public class SecondHr implements Hr {

    Collection<SecretaryImpl> secCandidates = new ArrayList<>();

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {
        SecretaryImpl secretary = (SecretaryImpl) candidate;
        int expectedAge = 30;
        if (secretary.age.getYears() < expectedAge) {
            secCandidates.add(secretary);
        }
        return secCandidates;
    }
}
