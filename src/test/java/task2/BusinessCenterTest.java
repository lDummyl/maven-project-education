package task2;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BusinessCenterTest {

    BusinessCenter businessCenter = new BusinessCenter();

    @Test
    public void createOfficeAll() throws Exception {
        Office office1 = businessCenter.createOffice();
        assertNotNull(office1.director);
        assertNotNull(office1.hr);

        Office office2 = businessCenter.createOffice(5);
        for (Accountant accountant : office2.accountants) {
            assertEquals(accountant.getClass(), Accountant.class);
        }

        Office office3 = businessCenter.createOfficeCand(3);
        assertNotNull(office3.allCandidates);
    }

    @Test
    public void createOfficesAll() throws Exception {
        int[] accountQtySequence = {3, 2, 1};
        List<Office> officeList1 = businessCenter.createOffices(accountQtySequence);
        for (Office office : officeList1) {
            assertNotNull(office.director);
            assertNotNull(office.hr);
        }
        int i = 3; // TODO: 7/3/20 да это изящное решение, но в тестах должно быть все очевидно просто stupid simple

        for (Office office : officeList1) {
//            assertEquals(office.requireOfAccountant, accountQtySequence[officeList1.indexOf(office)]); //так
            assertEquals(office.requireOfAccountant, i);
            i--;
        }

        List<Office> officeList2 = businessCenter.createOfficesCand(3, 2, 1); // TODO: 7/3/20 magic nums да и с повторением
        for (Office office : officeList2) {
            assertNotNull(office.director);
            assertNotNull(office.hr);
            assertNotNull(office.allCandidates);
        }
    }
}