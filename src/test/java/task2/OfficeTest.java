package task2;

import org.junit.Test;
import task1.PersonProvider;

import java.util.List;

import static org.junit.Assert.*;

public class OfficeTest {
    BusinessCenter businessCenter = new BusinessCenter();
    PersonProvider personProvider = new PersonProvider();
    Object object = new Object();
    Office office = businessCenter.createOfficeCand(1);
    List<OfficeWorker> officeWorkers = personProvider.getSomeAllCandidates(100);


    public OfficeTest() throws Exception {
    }

    @Test
    public void inviteSecretary() {
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        for (Secretary secretary : office.hr.approvedSecretary) {
            assertEquals(secretary.getClass(), Secretary.class);
        }
        assertTrue(office.hr.approvedSecretary.size() > 0);
    }

    @Test
    public void inviteSecurity() {
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        for (Security security : office.hr.approvedSecurity) {
            assertEquals(security.getClass(), Security.class);
        }
        assertTrue(office.hr.approvedSecurity.size() > 0);
    }

    @Test
    public void inviteJurist() {
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        for (Jurist jurist : office.hr.approvedJurist) {
            assertEquals(jurist.getClass(), Jurist.class);
        }
        assertTrue(office.hr.approvedJurist.size() > 0);
    }

    @Test
    public void inviteAccountant() {
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        for (Accountant accountant : office.hr.approvedAccountant) {
            assertEquals(accountant.getClass(), Accountant.class);
        }
        assertTrue(office.hr.approvedAccountant.size() > 0);
    }

    @Test
    public void init(){
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        office.init();
        assertTrue(office.secretaries.size() == 1);
        assertTrue(office.securities.size() == 1);
        assertTrue(office.jurists.size() == 1);
        assertTrue(office.accountants.size() == 1);
        assertTrue(office.allCandidates.size() == 0);
    }

    @Test
    public void work() {
        for (OfficeWorker officeWorker : officeWorkers) {
            office.invitePeople(officeWorker);
        }
        office.init();

        office.work(5, object, 100);
        assertTrue(office.secretaries.get(0).getColorNail() == "YELLOW"); // TODO: 7/3/20 а вот не стоит так строки сравнивать
        assertTrue(office.bankAccounts.get(0).getSum() == 49900);
    }

}