package task2;


import org.junit.Test;
import task1.CandidateProvider;
import task1.Person;


import java.util.*;

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
        int candidateSize = 1000;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidate);
        managers.forEach(secondHr::addCandidate);
        lawyers.forEach(secondHr::addCandidate);

//        Worker guard = localDirector.chooseWorker(secondHr.getCandidates(), Guard.class);
//        Worker manager = localDirector.chooseWorker(secondHr.getCandidates(), Manager.class);
//        Worker lawyer = localDirector.chooseWorker(secondHr.getCandidates(), Lawyer.class);
//
//        assertNotNull(guard);
//        assertNotNull(manager);
//        assertNotNull(lawyer);
//
//        assertEquals(Guard.class, guard.getClass());
//        assertEquals(Manager.class, manager.getClass());
//        assertEquals(Lawyer.class, lawyer.getClass());
//
//        assertTrue(guard.passInterview());
//        assertTrue(manager.passInterview());
//        assertTrue(lawyer.passInterview());
    }

    @Test
    public void testRightKey() throws IllegalStateException{
        LocalDirector localDirector = new LocalDirector(1);
        HashMap<Class<?>, List<Worker>> objectObjectHashMap = new HashMap<>();
        ArrayList<Worker> value = new ArrayList<>();
        SecretaryImpl newSecretary = new SecretaryImpl(new Person());
        value.add(newSecretary);
        objectObjectHashMap.put(SecretaryImpl.class, value);
        Optional<SecretaryImpl> secretary = localDirector.chooseWorker(objectObjectHashMap, SecretaryImpl.class);
        assertTrue(secretary.isPresent());
        assertEquals(newSecretary, secretary.get());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWrongKey() {
        LocalDirector localDirector = new LocalDirector(1);
        HashMap<Class<?>, List<Worker>> objectObjectHashMap = new HashMap<>();
        ArrayList<Worker> value = new ArrayList<>();
        value.add(new Guard(new Person()));
        objectObjectHashMap.put(SecretaryImpl.class, value);
        Optional<SecretaryImpl> secretary = localDirector.chooseWorker(objectObjectHashMap, SecretaryImpl.class);
    }
    @Test
    public void testEmptyOptional(){
        LocalDirector localDirector = new LocalDirector(2);
        HashMap<Class<?>, List<Worker>> objectObjectHashMap = new HashMap<>();
        ArrayList<Worker> value = new ArrayList<>();
        value.add(new SecretaryImpl(new Person()));
        objectObjectHashMap.put(SecretaryImpl.class, value);
        Optional<SecretaryImpl> secretary = localDirector.chooseWorker(objectObjectHashMap, SecretaryImpl.class);
        assertTrue(!secretary.isPresent());
    }

    @Test
    public void testCrushNoVar() {
        SecondHr secondHr = new SecondHr();
        LocalDirector localDirector = new LocalDirector();
        int candidateSize = 2;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidate);
        managers.forEach(secondHr::addCandidate);
        lawyers.forEach(secondHr::addCandidate);
        try {
//            Worker guard = localDirector.chooseWorker(secondHr.getCandidates(), Guard.class);
//            Worker manager = localDirector.chooseWorker(secondHr.getCandidates(), Manager.class);
//            Worker lawyer = localDirector.chooseWorker(secondHr.getCandidates(), Lawyer.class);
        } catch (IllegalArgumentException e) {
            assertTrue(true);
            assertEquals("Нету кандидатов прошедших интервью", e.getMessage());
        }
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