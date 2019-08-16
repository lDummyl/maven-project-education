package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class OfficeTest {

	@Test
	public void testOk() {
		Office office = new Office();

		ArrayList<Object> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Маша"));    //создаем секретарей
		secretaries.add(new Secretary("Алла"));
		secretaries.add(new Secretary("Анжелла"));
		secretaries.add(new Secretary("Зина"));
		secretaries.add(new Secretary("Марина"));
		secretaries.add(new Secretary("Лера"));

		secretaries.forEach(office::invitePeople);
		assertTrue(secretaries.contains(office.secretary));

	}

	@Test
	public void passEmptyList() {
		Office office = new Office();
		ArrayList<Object> secretaries = new ArrayList<>();

		secretaries.forEach(office::invitePeople);
		assertEquals(null, office.secretary);

	}

	@Test(expected = RuntimeException.class)
	public void getBossAnger() {
		Office office = new Office();
		ArrayList<Object> secretaries = new ArrayList<>();

		for (int i = 0; i < 6; i++)                       //создаем 6 кандидатов жилающих работать, но е совсем секретарей
			secretaries.add(new WantAWork() {
				@Override
				public boolean passInterview() {
					return true;                         //возвращаем положительный результат прохождения интерьвью у Hr
				}
			});

		secretaries.forEach(office::invitePeople);

	}

	@Test
	public void newOffices() {

		Office office = new Office();
		ArrayList<Office> additionalOffice = new ArrayList<>();

		ArrayList<Object> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Маша"));    //создаем секретарей
		secretaries.add(new Secretary("Алла"));
		secretaries.add(new Secretary("Анжелла"));
		secretaries.add(new Secretary("Зина"));
		secretaries.add(new Secretary("Марина"));
		secretaries.add(new Secretary("Лера"));

		secretaries.forEach(office::invitePeople);
		assertTrue(secretaries.contains(office.secretary));

		Stream stream = secretaries.stream();
		Stream stream2 = secretaries.stream();
		Stream stream3 = secretaries.stream();

		stream.limit(2).forEach(x -> additionalOffice.add(new Office("Офис №1", x)));            //возвращает первые два элемента
		stream2.skip(2).limit(2).forEach(y -> additionalOffice.add(new Office("Офис №2", y)));   //возвращает два элемента начиная со второго
		stream3.skip(4).forEach(z -> additionalOffice.add(new Office("Офис №3", z)));            //возвращает возвращает все элементы после четвертого


		Office offissNuber1 = null;
		for (int i = 0; i < additionalOffice.size(); i++) {
			Office offiss = additionalOffice.get(i);
			offiss.workingOffice();
			// TODO: 8/16/19 что-то не так способ 1
			if (offiss.nameOffice.equals("Офис №1")) {
				if (offissNuber1 == null) {
					offissNuber1 = offiss;
				} else {
					if (!offiss.equals(offissNuber1)) {
						System.out.println("как это офис 1 уже есть, не не равен офису 1, ¯\\_(ツ)_/¯");
						assertTrue(offiss.equals(offissNuber1));
					}
				}
			}
		}
		// TODO: 8/16/19 способ 2
		long offices1qty = additionalOffice.stream().filter(off -> off.nameOffice.equals("Офис №1")).count();
		assertThat("Offices 1 qty", offices1qty, lessThan(2L));
	}
}