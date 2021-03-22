package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class OfficeTest {

	@Test
	public void selectSecretaryValid() {
		List<Object> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Маша"));
		secretaries.add(new Secretary("Алла"));
		secretaries.add(new Secretary("Анжелла"));
		secretaries.add(new Secretary("Зина"));
		secretaries.add(new Secretary("Марина"));
		secretaries.add(new Secretary("Лера"));
		Office office = new Office();
		secretaries.forEach(office::invitePeople);
		System.out.println(office.secretary);
		assertTrue(secretaries.contains(office.secretary));
	}
}