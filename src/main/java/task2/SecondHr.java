package task2;

import java.util.ArrayList;
import java.util.Collection;

public class SecondHr implements Hr {
    Collection<Guard> guardCandidates = new ArrayList<>();
    Collection<SecretaryImpl> secCandidates = new ArrayList<>();
    Collection<Manager> managersCandidates = new ArrayList<>();

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {
        SecretaryImpl secretary = (SecretaryImpl) candidate;
        int expectedAge = 30;
        if (secretary.age.getYears() < expectedAge) {
            secCandidates.add(secretary);
        }
        return secCandidates;
    }

    public Collection<Guard> addGuardCandidate(Object candidate) {
        int expectedAge = 30;

        Guard guard = (Guard) candidate;
        if (guard.age.getYears() < expectedAge) {
            guardCandidates.add(guard);
        }
        return guardCandidates;
    }

    public Collection<Manager> addManagerCandidate(Object candidate) {

        Manager guard = (Manager) candidate;
        managersCandidates.add(guard);

        return managersCandidates;
    }

}
