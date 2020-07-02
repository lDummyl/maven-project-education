package task1;

import org.junit.Test;
import task2.*;

import java.util.List;

import static org.junit.Assert.*;

public class PersonProviderTest {

    @Test
    public void getSomePerson() {
        PersonProvider menPersonProvider = new PersonProvider();
        Person somePerson = menPersonProvider.getSomePerson();
        assertNotNull(somePerson.getName().lastName);
        assertTrue(PersonProvider.lastN.contains(somePerson.getName().lastName));
        assertFalse(PersonProvider.firstN.contains(somePerson.getName().lastName));
    }

    @Test
    public void getSomeAllOfficeWorker() {
        PersonProvider personProvider = new PersonProvider();
        List<Secretary> secretaries = personProvider.getSomeSecretaries(1);
        List<Security> securities = personProvider.getSomeSecurities(1);
        List<Jurist> jurists = personProvider.getSomeJurists(1);
        List<Accountant> accountants = personProvider.getSomeAccountants(1);

        assertEquals(secretaries.get(0).getClass(), Secretary.class);
        assertEquals(securities.get(0).getClass(), Security.class);
        assertEquals(jurists.get(0).getClass(), Jurist.class);
        assertEquals(accountants.get(0).getClass(), Accountant.class);
    }

    @Test
    public void getSomeCandidates() throws Exception {
        PersonProvider personProvider = new PersonProvider();
        List<? extends OfficeWorker> officeWorkers = personProvider.getSomeOf(10, Security.class, Secretary.class,
                Jurist.class);
        for (OfficeWorker officeWorker : officeWorkers) {
            assertFalse(officeWorker instanceof Accountant);
        }
    }

    @Test
    public void sizeListCandidates(){
        PersonProvider personProvider = new PersonProvider();
        List<Person> personList = personProvider.getSomePerson(20);
        assertEquals(20, personList.size());
    }

    @Test
    public void getAdministrationOffice(){
        PersonProvider personProvider = new PersonProvider();
        Director director = personProvider.getSomeDirector();
        Hr hr = personProvider.getSomeHr();

        assertTrue(PersonProvider.firstN.contains(director.getName().firstName));
        assertTrue(PersonProvider.lastN.contains(director.getName().lastName));
        assertTrue(PersonProvider.firstN.contains(hr.getPerson().getName().firstName));
        assertTrue(PersonProvider.lastN.contains(hr.getPerson().getName().lastName));
    }

    @Test(expected = Exception.class)
    public void getOfficeWorkerException() throws Exception {
        PersonProvider personProvider = new PersonProvider();
        List<OfficeWorker> officeWorkers = personProvider.getSomeOfNoGen(Object.class, 10);
    }





}