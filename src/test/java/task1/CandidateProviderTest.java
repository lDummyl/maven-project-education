package task1;

import org.junit.Test;
import task2.Secretary;

import java.util.Collection;

import static org.junit.Assert.*;

public class CandidateProviderTest {


    @Test
    public void generateCandidate() {
        CandidateProvider candidateProvider = new CandidateProvider();
        Collection<CandidateProvider.Secretary> secretaries = candidateProvider.generateCandidate(100, Secretary.class);

        for (CandidateProvider.Secretary s : secretaries) {
            assertFalse(s == null);
            System.out.println(s.experience);
        }

    }
}
