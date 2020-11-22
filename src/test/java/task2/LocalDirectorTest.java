package task2;


import org.junit.Test;
import task1.CandidateProvider;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LocalDirectorTest {
    Office apple = new Office(new GeneralDirector(), new SecondHr());
    CandidateProvider candidateProvider = new CandidateProvider();


    @Test
    public void testChooseSecretary() {

    }

    @Test
    public void testChooseWorker() {
        SecondHr secondHr = new SecondHr();
        LocalDirector localDirector = new LocalDirector();
        int candidateSize = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidate);
        managers.forEach(secondHr::addCandidate);
        lawyers.forEach(secondHr::addCandidate);

        Worker guard = localDirector.chooseWorker(secondHr.getCandidates(), Guard.class);
        Worker manager = localDirector.chooseWorker(secondHr.getCandidates(), Manager.class);
        Worker lawyer = localDirector.chooseWorker(secondHr.getCandidates(), Lawyer.class);

        assertNotNull(guard);
        assertNotNull(manager);
        assertNotNull(lawyer);

        assertEquals(Guard.class, guard.getClass());
        assertEquals(Manager.class, manager.getClass());
        assertEquals(Lawyer.class, lawyer.getClass());

        assertTrue(guard.passInterview());
        assertTrue(manager.passInterview());
        assertTrue(lawyer.passInterview());
    }

    @Test
    public void crushTest() {
        HashMap<Class<?>, List<Worker>> voidMap = new HashMap<>();
        LocalDirector localDirector = new LocalDirector();
        try {
            localDirector.chooseWorker(voidMap, Guard.class);
        } catch (NullPointerException e) {
            assertTrue(true);
            assertEquals("Пустой список кандидатов", e.getMessage());
        }

    }
}