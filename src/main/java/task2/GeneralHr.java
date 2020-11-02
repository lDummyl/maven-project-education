package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.Collection;

public class GeneralHr implements Hr {



    @Override
    public Collection<Secretary> addSecretaryCandidate(Object candidate) {
        Collection<Secretary> secCandidates = new ArrayList<>();

        secCandidates.add((Secretary) candidate);
        System.out.println(secCandidates.size());
        return secCandidates;
    }
}
