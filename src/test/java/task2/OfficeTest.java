package task2;

import org.junit.Test;
import task2.oldOffice.Office;

import static org.junit.Assert.assertTrue;


public class OfficeTest {

	// TODO: 1/17/20 тут нужно создать несколько тест кейсов в том числе не валидных чтобы мы могли например убедится что если сотрудников 4 а нужно 5ть
	//  то никто не будет принят на работу. Я бы для удобства создал отдельный класс EmployeeSupplier, который будет снабжать нас нужными сотрудниками в заданном количестве
	//  его методы и поля можешь сделать статическими на роль Бога творца он в данном контексте подходит.

	@Test
	public void inviteSecretarySuccess() {
		//EmployeeSupplier employeeSupplier = new EmployeeSupplier();
		//List<Secretary> candidates = EmployeeSupplier.getSecretaries(10);
	//	Office office = new Office(Office.Mode.RANDOM);
	//	office.invite();
	//	assertTrue(office.secretary != null);

	}
	@Test
	public void inviteSecretaryFail() {
//		List<Secretary> candidates = EmployeeSupplier.getSecretaries(2);
	//	Office office = new Office(Office.Mode.RANDOM);
//		office.invite();
	//	assertTrue(office.secretary == null);

	}
}