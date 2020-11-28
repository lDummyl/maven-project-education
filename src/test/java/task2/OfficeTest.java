package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class OfficeTest {
	 /*не понимаю что тут тестировать, этот метод обращается только к внешним объектам и присваивает
	 package-protected полям значения
	 нужно ли соблюдать первоначальное условие о том что у класса должен быть только
	 один публичный метод?*/
	@Test
	public void invitePeople() {

		Office office = new Office(new Director(2), new Hr());
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Secretary());
		employeeList.add(new Secretary());

		employeeList.forEach(office::invitePeople);


	}
}