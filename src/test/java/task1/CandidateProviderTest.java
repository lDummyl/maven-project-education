package task1;

import org.junit.Test;
import task2.Secretary;

import java.util.Collection;

import static org.junit.Assert.*;

public class CandidateProviderTest {


    @Test
    public void generateCandidate() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int numberOfCandidate = 100;
        Collection<CandidateProvider.Secretary> secretaries = candidateProvider.generateCandidate(numberOfCandidate, Secretary.class);
        assertTrue(secretaries.size() == numberOfCandidate);

        for (CandidateProvider.Secretary s : secretaries) {
            assertFalse(s == null);
            assertTrue(s.experience!=null);
            assertTrue(s.experience >= 0);

            //System.out.println(s.experience);
        }

    }
}
