package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class GeneralHr extends SecondHr implements Hr {

    Collection<SecretaryImpl> secCandidates;
    Collection<ChiefGuard> guards;

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {

        secCandidates.add((SecretaryImpl) candidate);
        System.out.println(secCandidates.size());
        return secCandidates;
    }

}
