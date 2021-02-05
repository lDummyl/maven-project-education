package task2;

import org.junit.Ignore;
import org.junit.Test;
import task1.CandidateProvider;
import task2.workers.*;


import java.util.List;

import static org.junit.Assert.*;

public class OfficeTest {

    // TODO: 11/16/20  сделай тест что один и тот же секретарь не работает 2х офисх одновременно
    //  для этого проще завести много офисов и мало кандидатов

    Office apple = new Office(new GeneralDirector(), new GeneralHr());
    CandidateProvider candidateProvider = new CandidateProvider();

    @Test
    public void initTest() {
        SecondHr secondHr = new SecondHr();
        LocalDirector localDirector = new LocalDirector();
        int candidateSize = 100;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(secondHr::addCandidate);
        managers.forEach(secondHr::addCandidate);
        lawyers.forEach(secondHr::addCandidate);

//        Worker guard = localDirector.chooseWorker(secondHr.getCandidates(), Guard.class);
//        Worker manager = localDirector.chooseWorker(secondHr.getCandidates(), Manager.class);
//        Worker lawyer = localDirector.chooseWorker(secondHr.getCandidates(), Lawyer.class);

        //apple.setGuard((Guard) guard);
        //apple.setManager((Manager) manager);
        //apple.setGuard((Guard) guard);
    }

    @Test
    public void setWorkerTest() {
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
//        apple.setWorker(guard);
//        apple.setWorker(manager);
//        apple.setWorker(lawyer);
//
//        assertNotNull(apple.guard);
//        assertNotNull(apple.manager);
//        assertNotNull(apple.lawyer);

    }

    // FIXME: 22.11.2020 директор выдаёт exception, что нету кандидатов прошедших интервью
    // FIXME: 22.11.2020 не забыть серетарей
    // FIXME: 07.12.2020 Охранники не прохордят интервью
    @Test
    @Ignore
    public void invitePeopleTest() {
        Office office = new Office(new LocalDirector(), new SecondHr());
        int candidateSize = 1000;
        List<Guard> guards = candidateProvider.generateAnyWorkers(candidateSize, Guard::new);
        List<Manager> managers = candidateProvider.generateAnyWorkers(candidateSize, Manager::new);
        List<Lawyer> lawyers = candidateProvider.generateAnyWorkers(candidateSize, Lawyer::new);

        guards.forEach(office::invitePeople);
        managers.forEach(office::invitePeople);
        lawyers.forEach(office::invitePeople);

        assertNotNull(office.guard);
        assertNotNull(office.manager);
        assertNotNull(office.lawyer);

        assertEquals(Guard.class, office.guard.getClass());

        assertEquals(Manager.class, office.manager.getClass());
        assertEquals(Lawyer.class, office.lawyer.getClass());
    }

    @Test
    public void crushTest() {
        Object o = new Object();
        Office djenga = new Office(new GeneralDirector(), new GeneralHr());
        try {
      //      djenga.invitePeople(o);
        } catch (IllegalStateException e) {
            e.getMessage();
        }
    }

    @Test
    public void anotherSec() {


    }

}