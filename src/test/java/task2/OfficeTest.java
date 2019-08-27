package task2;

import org.junit.Test;

import java.util.*;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class OfficeTest {

    Logger log = Logger.getLogger(HrTest.class.getName());
    Settings settings = new Settings();
    Office office = new Office();

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

        assertTrue(office.getHr() != null);
        assertTrue(office.getSecretary() != null);
        assertTrue(office.getSecurity() != null);
        assertTrue(office.getLawyer() != null);
        assertTrue(office.getAccountants().size() == 2);

        office.setAccountants(office.getAccountants());

        log.info(office.getAccountants().toString());
        assertTrue(office.getAccountants().size() == 2);
    }

    @Test
    public void invitePeopleUnValidate() {
        settings.addSecretary(2);
        settings.addSecurityOfficer(2);
        settings.addLawyer(1);
        settings.addAccountant(3);
        settings.addSluggard(3);

        office.invitePeaople(settings.getLabourMarket());

        assertTrue(office.getHr() != null);
        assertTrue(office.getSecretary() == null);
        assertTrue(office.getSecurity() == null);
        assertTrue(office.getLawyer() == null);
        assertTrue(office.getAccountants().size() != 2);
    }
}
