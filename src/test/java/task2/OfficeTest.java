package task2;

import org.junit.Test;
import task1.CandidateProvider;

import java.util.Collection;

import static org.junit.Assert.*;

public class OfficeTest {
    Office apple = new Office(new GeneralDirector(), new GeneralHr());
    Office google = new Office(new SecondDirector(), new SecondHr());
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