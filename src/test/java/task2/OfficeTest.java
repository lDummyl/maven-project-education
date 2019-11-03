package task2;

import org.junit.Test;
import task2.People.*;

import static org.junit.Assert.assertNotNull;


public class OfficeTest {

	// TODO: 10/22/19 не забудь перенести логику из теста ктотрый мы сделали.
	@Test
	public void inviteToAudition() {

		Office office = new Office();
		// TODO: 11/3/19 заводить для каждого человека класс, это немного противоречит самой концепции класса.
		office.inviteToAudition(new LarisaIvanovna("Larisa", 56, Gender.Female));
		office.inviteToAudition(new SergeyPetrovich("Sergey", 34, Gender.Male));
		office.inviteToAudition(new VladimirSergeyevich("Vladimir", 26, Gender.Male));
		office.inviteToAudition(new AnnaNikolayevna("Anna", 28, Gender.Female));
		office.inviteToAudition(new EvgeniyaSemenovna("Evgeniya", 35, Gender.Female));
		office.inviteToAudition(new NikitaPavlovich("Nikita", 32, Gender.Male));
		assertNotNull(office.getSecretary());

	}
}