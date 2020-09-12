package task2.model;

import java.util.Collection;

public class AppleHR implements Hr {

    @Override
    public Collection<Secretary> addSecretaryCandidate(Object candidate) {
        return (Collection<Secretary>) candidate;
    }
}
