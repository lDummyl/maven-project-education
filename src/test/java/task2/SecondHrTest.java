package task2;

import junit.framework.TestCase;
import task1.CandidateProvider;

import java.util.Collection;

import static org.junit.Assert.assertNotNull;

public class SecondHrTest extends TestCase {
    Office apple = new Office(new GeneralDirector(), new GeneralHr());
    CandidateProvider candidateProvider = new CandidateProvider();


    public void testAddSecretaryCandidate() {
        Collection<SecretaryImpl> secretaries = candidateProvider.generateSecretaries(100);
        secretaries.forEach(apple::invitePeople);
        assertNotNull(apple.secretary);
    }

    public void testAddGuardCandidate() {
        Collection<Guard> guards = candidateProvider.generateSecurity(100);
        guards.forEach(apple.hr::addGuardCandidate);
        assertNotNull(apple.secretary);
    }

    public void testDismiss() {
    }
}