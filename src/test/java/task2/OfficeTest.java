package task2;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class OfficeTest {

	// TODO: 10/22/19 не забудь перенести логику из теста ктотрый мы сделали.
	@Test
	public void inviteToAudition() {

		Office office = new Office();
		office.inviteToAudition(new Person("Larisa", 56, "female"));
//        assertTrue(office.getSecretary() != null);
		assertNotNull(office.getSecretary());

	}
}