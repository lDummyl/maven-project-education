package task2;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.Test;
import task1.CandidateProvider;

import java.util.*;

import static org.junit.Assert.*;

public class SecondHrTest {
    Office apple = new Office(new GeneralDirector(), new SecondHr());
    CandidateProvider candidateProvider = new CandidateProvider();
    int numberOfCandidate = 100;


    @Test
    public void addCandidate(){
        SecondHr secondHr = new SecondHr();
        Collection<Guard> guards = candidateProvider.generateAnyWorkers(1, Guard::new);
        ArrayList<Guard> guardsList = new ArrayList<>(guards);
        secondHr.addCandidate(guardsList.get(0));
        assertEquals(guardsList.size(),secondHr.getCandidates().size());
        System.out.println(secondHr.getCandidates());
    }
    @Test
    public void addCandidateMany(){
        SecondHr secondHr = new SecondHr();
        int guardSize = 100;
        Collection<Guard> guards = candidateProvider.generateAnyWorkers(guardSize, Guard::new);
        ArrayList<Guard> guardsList = new ArrayList<>(guards);
        for (Guard guard : guardsList) {
            secondHr.addCandidate(guard);
        }
        Map<Class<?>, List<Worker>> candidates = secondHr.getCandidates();
        assertEquals(1, candidates.size());
        assertEquals(guardSize,candidates.get(Guard.class).size());
        System.out.println(candidates);
    }
    @Test
    public void addCandidateManyTypes(){
        SecondHr secondHr = new SecondHr();
        int candidateSize = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidate);
        managers.forEach(secondHr::addCandidate);
        lawyers.forEach(secondHr::addCandidate);

        Map<Class<?>, List<Worker>> candidates = secondHr.getCandidates();
        int numberOfFolders = 3;
        assertEquals(numberOfFolders, candidates.size());

        System.out.println(candidates);
    }
    @Test (expected = IllegalStateException.class)
    public void addCandidateCrush(){
        SecondHr secondHr = new SecondHr();
        int candidateSize = 100;

        try {
            secondHr.addCandidate(new Object());
        } catch (IllegalStateException e) {
            assertTrue(true);
            assertEquals("Wrong object", e.getMessage());
            throw e;
        }
    }
}