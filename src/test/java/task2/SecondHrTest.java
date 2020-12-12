
package task2;

import org.junit.Test;
import task1.CandidateProvider;

import java.util.*;

import static org.junit.Assert.*;

public class SecondHrTest {
    Office apple = new Office(new GeneralDirector(), new SecondHr());
    CandidateProvider candidateProvider = new CandidateProvider();


    @Test
    public void addCandidateMany() {
        SecondHr secondHr = new SecondHr();
        int guardSize = 100;
        Collection<Guard> guards = candidateProvider.generateAnyWorkers(guardSize, Guard::new);
        ArrayList<Guard> guardsList = new ArrayList<>(guards);
        for (Guard guard : guardsList) {
            secondHr.addCandidateDet(guard);
        }
        Map<Class<?>, List<Worker>> candidates = secondHr.getCandidates();
        System.out.println(secondHr.getCandidates());
        candidates.get(Guard.class).size();

        assertTrue(candidates.get(Guard.class).size() > 0);
    }

    @Test
    public void addCandidateManyTypes() {
        SecondHr secondHr = new SecondHr();
        int candidateSize = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidateDet);
        managers.forEach(secondHr::addCandidateDet);
        lawyers.forEach(secondHr::addCandidateDet);

        Map<Class<?>, List<Worker>> candidates = secondHr.getCandidates();
        int numberOfFolders = 3;
        assertEquals(numberOfFolders, candidates.size());

    }
}
