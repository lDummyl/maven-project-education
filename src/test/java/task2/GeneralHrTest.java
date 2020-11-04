package task2;

import org.junit.Assert;
import org.junit.Test;
import task1.CandidateProvider;

import java.util.Collection;

import static org.junit.Assert.*;

public class GeneralHrTest {
    CandidateProvider candidateProvider = new CandidateProvider();
    GeneralHr generalHr = new GeneralHr();
    int numberOfCandidates = 100;

    @Test
    public void addSecretaryCandidate() {
        Collection<SecretaryImpl> secretaries = candidateProvider.generateSecretaries(100);
        secretaries.forEach(generalHr::addSecretaryCandidate);
        assertEquals(generalHr.secCandidates.size(), numberOfCandidates);
        secretaries.forEach(Assert::assertNotNull);
        generalHr.secCandidates.forEach(secretary -> secretary.sayHelloTo(null));
    }
}