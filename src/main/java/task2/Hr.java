package task2;

import java.util.Collection;



public interface Hr {
    Collection<SecretaryImpl> addSecretaryCandidate(Object candidate);
    Collection<Guard> addGuardCandidate (Object candidate);
}
