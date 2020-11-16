package task2;

import org.junit.Test;
import task1.CandidateProvider;

import java.util.Collection;

import static org.junit.Assert.*;

public class OfficeTest {

    // TODO: 11/16/20  сделай тест что один и тот же секретарь не работает 2х офисх одновременно
    //  для этого проще завести много офисов и мало кандидатов

    Office apple = new Office(new GeneralDirector(), new GeneralHr());
    Office google = new Office(new LocalDirector(), new SecondHr());
    CandidateProvider candidateProvider = new CandidateProvider();


    @Test
    public void setSecretary() {
    }

    @Test
    public void invitePeople() {
        Collection<SecretaryImpl> secretaries = candidateProvider.generateSecretaries(100);
        secretaries.forEach(apple::invitePeople);
        assertNotNull(apple.secretary);
    }
}