package task2;

import static org.junit.Assert.*;
import org.junit.Test;



public class OfficeTest {

	ProviderEmployee providerEmployee = new ProviderEmployee(100);

	@Test
	public void invitePeople() {

		Office office = new Office(new Director(2), new Hr());
		providerEmployee.getMapProvider().forEach((k,v) -> v.forEach(office::invitePeople));

		assertNotNull(office.secretary);
		assertNotNull(office.security);
		assertNotNull(office.lawyer);
		assertNotNull(office.firstAccountant);
		assertNotNull(office.secondAccountant);

		assertEquals(Secretary.class, office.secretary.getClass());
		assertEquals(Security.class, office.security.getClass());
		assertEquals(Lawyer.class, office.lawyer.getClass());
		assertEquals(Accountant.class, office.firstAccountant.getClass());
		assertEquals(Accountant.class, office.secondAccountant.getClass());
	}
}