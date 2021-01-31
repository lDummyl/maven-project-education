package task2;

import junit.framework.TestCase;
import task1.CandidateProvider;


import java.util.List;

public class WorkerTest extends TestCase {

    public void testPassInterview() {
        CandidateProvider candidateProvider = new CandidateProvider();
        int candidateSize = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);
    }
}