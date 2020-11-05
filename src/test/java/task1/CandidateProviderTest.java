package task1;

import org.junit.Test;
import task2.SecretaryImpl;

import java.util.Collection;

import static org.junit.Assert.*;

public class CandidateProviderTest {


    @Test
    public void generateSecretaries() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int numberOfCandidate = 100;
        Collection<SecretaryImpl> secretaries = candidateProvider.generateSecretaries(numberOfCandidate);
        assertEquals(numberOfCandidate , secretaries.size());

        for (SecretaryImpl s : secretaries) {
            assertFalse(s == null);
            assertTrue(s.experience != null);
            assertTrue(s.experience >= 0);

            //System.out.println(s.experience);
        }


    }


    @Test
    public void generateCandidate() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int numberOfCandidate = 100;
//        Collection<Secretary> secretaries = candidateProvider.generateCandidate(numberOfCandidate, Lawyer.class);
//        assertEquals(numberOfCandidate , secretaries.size());
//
//        for (Secretary s : secretaries) {
//            assertFalse(s == null);
//            assertTrue(s.experience != null);
//            assertTrue(s.experience >= 0);
//
//            //System.out.println(s.experience);
//        }


    }
}
