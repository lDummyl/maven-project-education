package task2;

import junit.framework.TestCase;
import task1.CandidateProvider;

import java.util.Collection;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;

public class SecondHrTest extends TestCase {
    Office apple = new Office(new GeneralDirector(), new SecondHr());
    CandidateProvider candidateProvider = new CandidateProvider();
    int numberOfCandidate = 100;


  /*  public void testAddSecretaryCandidate() {
        Collection<SecretaryImpl> secretaries = candidateProvider.generateSecretaries(numberOfCandidate);
        for (SecretaryImpl s : secretaries) {
            assertNotNull(s);
        }
        assertEquals(numberOfCandidate, secretaries.size());
    }

    public void testAddGuardCandidate() {
        Collection<Guard> guards = candidateProvider.generateSecurity(100);
        guards.forEach(apple.hr::addGuardCandidate);
        for (Guard g : guards) {
            assertNotNull(g);
        }
    }
    public void testAddManagerCandidate() {
        Collection<Manager> managers = candidateProvider.generateManager(100);
        managers.forEach(apple.hr::addManagerCandidate);
        for (Manager m : managers) {
            assertNotNull(m);

        }*/
  //  }
}