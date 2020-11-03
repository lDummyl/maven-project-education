package task2;

import java.util.ArrayList;
import java.util.Collection;

public class GeneralHr implements Hr {

    Collection<SecretaryImpl> secCandidates = new ArrayList<>();

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {


        secCandidates.add((SecretaryImpl) candidate);
        System.out.println(secCandidates.size());
        return secCandidates;
    }
}
