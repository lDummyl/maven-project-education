package task1;

import org.junit.Test;
import task2.workers.Guard;

import java.util.List;

import static org.junit.Assert.*;

public class CandidateProviderTest {

    @Test
    public void generateAnyWorkers() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int numberOfCandidate = 1;
        List<Guard> guards = candidateProvider.generateAnyWorkers(numberOfCandidate, Guard::new);
        Guard guard = guards.get(0);

        assertNotNull(guard);
    }
    @Test
    public void generateAnyWorkersMany() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int numberOfCandidate = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(numberOfCandidate, Guard::new);

        assertEquals(numberOfCandidate, guards.size());
    }
}