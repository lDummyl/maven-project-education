package task2;

import org.junit.Test;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class OfficeTest {

    private Logger log = Logger.getLogger(HrTest.class.getName());
    private Settings settings = new Settings();
    private Office office = new Office();

    @Test
    public void invitePeople() {
        settings.addSecretary(2000);
        settings.addSecurityOfficer(2000);
        settings.addLawyer(2000);
        settings.addAccountant(2000);
        settings.addSluggard(4000);

        office.invitePeaople(settings.getLabourMarket());

        log.info(office.getHr().toString());
        log.info(office.getSecretary().toString());
        log.info(office.getSecurity().toString());
        log.info(office.getLawyer().toString());
        log.info(office.getAccountants().toString());

        assertNotNull(office.getHr());
        assertNotNull(office.getSecretary());
        assertNotNull(office.getSecurity());
        assertNotNull(office.getLawyer());
        assertEquals(2, office.getAccountants().size());

        office.setAccountants(office.getAccountants());

        log.info(office.getAccountants().toString());
        assertEquals(2, office.getAccountants().size());
    }

    @Test
    public void invitePeopleUnValidate() {
        settings.addSecretary(2);
        settings.addSecurityOfficer(2);
        settings.addLawyer(1);
        settings.addAccountant(3);
        settings.addSluggard(3);

        office.invitePeaople(settings.getLabourMarket());

        assertNotNull(office.getHr());
        assertNull(office.getSecretary());
        assertNull(office.getSecurity());
        assertNull(office.getLawyer());
        assertTrue(office.getAccountants().size() != 2);
    }
}
