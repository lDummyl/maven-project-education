package task2;

import org.junit.Test;
import task1.PersonProvider;

import java.util.List;

import static org.junit.Assert.*;

public class HrTest {
    PersonProvider personProvider = new PersonProvider();
    Hr hr = personProvider.getSomeHr();
    final int qty = 10;
    List<OfficeWorker> officeWorkers = personProvider.getSomeAllCandidates(qty);

    public HrTest() throws Exception {
    }

    @Test
    public void sort() {
        for(int i = 0; i < 4 * qty; i++){
            hr.sort(officeWorkers.get(i));
        }
        for (Secretary secretary : hr.approvedSecretary) {
            assertEquals(secretary.getClass(), Secretary.class);
        }
        for (Security security : hr.approvedSecurity) {
            assertEquals(security.getClass(), Security.class);
        }
        for (Jurist jurist : hr.approvedJurist) {
            assertEquals(jurist.getClass(), Jurist.class);
        }
        for (Accountant accountant : hr.approvedAccountant) {
            assertEquals(accountant.getClass(), Accountant.class);
        }
    }

    @Test
    public void kickOutCandidates() {
        int beforeSize = officeWorkers.size();
        hr.kickOutCandidates(officeWorkers);
        int afterSize = officeWorkers.size();
        assertTrue(beforeSize > afterSize);
    }

    @Test
    public void invite() {
        for (int i = 0; i < 4 * qty; i++){
            hr.invite(officeWorkers.get(i));
        }
        int allApprovedSize = hr.approvedAccountant.size() + hr.approvedJurist.size() +
                hr.approvedSecurity.size() + hr.approvedSecretary.size();
        assertTrue(officeWorkers.size() > allApprovedSize);
    }

}