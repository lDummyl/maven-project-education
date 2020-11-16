package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class GeneralHr extends SecondHr implements Hr {

    Collection<SecretaryImpl> secCandidates;
    Collection<ChiefGuard> guards;

    @Override
    public Collection<SecretaryImpl> addSecretaryCandidate(Object candidate) {

        // TODO: 11/16/20 познакомься с методом getClass у объекта и помести всех твоих кандидатов в мапу Map<Class<?>, List<Worker>>
        //  и сделай так что у каждого worker есть метод boolean passInterview() который вызывает hr икто-то может, а кто не нет.
        secCandidates.add((SecretaryImpl) candidate);
        System.out.println(secCandidates.size());
        return secCandidates;
    }

}
