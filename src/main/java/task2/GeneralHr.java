package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.Collection;

public class GeneralHr implements Hr {

    Collection<Secretary> secCandidates = new ArrayList<>();

    @Override
    public Collection<Secretary> addSecretaryCandidate(Object candidate) {

        secCandidates.add((Secretary) candidate);
        System.out.println(secCandidates.size());
        return secCandidates;
    }
}
