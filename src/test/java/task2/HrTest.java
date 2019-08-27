package task2;

import org.junit.Test;

import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HrTest {

    Logger log = Logger.getLogger(HrTest.class.getName());
    Settings settings = new Settings();
    Hr hr = new Hr();

    @Test
    public void checkHr() {
        settings.addSecretary(2000);
        settings.addSecurityOfficer(2000);
        settings.addLawyer(2000);
        settings.addAccountant(2000);
        settings.addSluggard(4000);

        List<Object> labourMarket = settings.getLabourMarket();
        for (Object candidate : labourMarket) {
            if (candidate instanceof WantAJob) {
                hr.interview((WantAJob) candidate);
            }
        }
        assertTrue(hr.getSecretaries().isEmpty());

        hr.selectCandidates();

        assertTrue(hr.getSecretaries().size() == 2000);
        assertTrue(hr.getSecurities().size() == 2000);
        assertTrue(hr.getLawyers().size() == 2000);
        assertTrue(hr.getAccountants().size() == 2000);
        assertTrue(hr.getCandidates().size() == 12000);
    }

    @Test
    public void checkHrSecretaries() {
        List<Secretary> secretaries = hr.getSecretaries();
        log.info("Secretary -> " + secretaries);
        List<String> collect = secretaries.stream().map(Employee::getName).collect(Collectors.toList());
        Collection<String> checkNames = Settings.womenNames;

        assertTrue(secretaries.isEmpty());
        assertTrue(!collect.containsAll(checkNames));

        settings.addSecretary(1000);
        settings.addAccountant(1000);
        settings.addLawyer(1000);

        List<Object> labourMarket = settings.getLabourMarket();
        for (Object candidate : labourMarket) {
            if (candidate instanceof WantAJob) {
                hr.interview((WantAJob) candidate);
            }
        }

        assertTrue(hr.getSecretaries().isEmpty());

        hr.selectCandidates();
        secretaries = hr.getSecretaries();

        assertFalse(secretaries.isEmpty());
        assertTrue(secretaries.size() == 1000);
        assertTrue(hr.getCandidates().size() == 3000);
    }

    @Test
    public void checkHrSecurityOfficers() {
        List<SecurityOfficer> security = hr.getSecurities();

        assertTrue(security.isEmpty());

        settings.addSecurityOfficer(10000);
        settings.addLawyer(1000);
        settings.addSluggard(1000);

        List<Object> labourMarket = settings.getLabourMarket();
        for (Object candidate : labourMarket) {
            if (candidate instanceof WantAJob) {
                hr.interview((WantAJob) candidate);
            }
        }

        assertTrue(hr.getSecurities().isEmpty());

        hr.selectCandidates();
        security = hr.getSecurities();

        assertFalse(security.isEmpty());
        assertTrue(security.size() == 10000);
        assertTrue(hr.getCandidates().size() == 12000);
    }
}