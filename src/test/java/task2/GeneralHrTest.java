package task2;

import org.junit.Test;
import task1.CandidateProvider;
import task1.PersonsProvider;

import java.util.Collection;
import java.util.TreeSet;

import static org.junit.Assert.*;

public class GeneralHrTest {
    CandidateProvider candidateProvider = new CandidateProvider();
    GeneralHr generalHr = new GeneralHr();
    int numberOfCandidates = 100;

    @Test
    public void addSecretaryCandidate() {
        Collection<CandidateProvider.Secretary> secretaries = candidateProvider.generateCandidate(100, Secretary.class);

        secretaries.stream().forEach(generalHr::addSecretaryCandidate);
        assertTrue(generalHr.secCandidates.size() == numberOfCandidates);
        secretaries.stream().forEach(secretary -> assertTrue(secretary!=null));
        generalHr.secCandidates.stream().forEach(secretary->secretary.sayHelloTo(null));

    }
}