package task2;

import org.junit.Test;
import task2.People.*;

import static org.junit.Assert.assertNotNull;


public class OfficeTest {

	// TODO: 10/22/19 не забудь перенести логику из теста ктотрый мы сделали.
	@Test
	public void inviteToAudition() {

		Office office = new Office();
		office.inviteToAudition(new LarisaIvanovna("Larisa", 56, "female"));
		office.inviteToAudition(new SergeyPetrovich("Sergey", 34, "male"));
		office.inviteToAudition(new VladimirSergeyevich("Vladimir", 26, "male"));
		office.inviteToAudition(new AnnaNikolayevna("Anna", 28, "female"));
		office.inviteToAudition(new EvgeniyaSemenovna("Evgeniya", 35, "female"));
		office.inviteToAudition(new NikitaPavlovich("Nikita", 32, "male"));
		assertNotNull(office.getSecretary());

	}
}