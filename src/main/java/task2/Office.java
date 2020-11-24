package task2;

import java.util.Optional;
import java.util.function.Supplier;

public class Office {

	Director director;

	Hr hr;

	Secretary secretary;
	Lawyer lawyer;
	Security security;
	Accountant firstAccountant;
	Accountant secondAccountant;

	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат


	void invitePeople(Object human){
		hr.checkEmployee(human);
		secretary = getOptional(secretary).orElseGet(() -> director.chooseEmployee(hr.getListEmployee(), Secretary.class));
		lawyer = getOptional(lawyer).orElseGet(() -> director.chooseEmployee(hr.getListEmployee(), Lawyer.class));


//		secretary = director.chooseEmployee(hr.getListEmployee(), Secretary.class);
//		lawyer = (Lawyer) director.chooseEmployee(lawyer, hr.getListEmployee(), Lawyer.class);
//		security = (Security) director.chooseEmployee(security, hr.getListEmployee(), Security.class);
//		firstAccountant = (Accountant) director.chooseEmployee(firstAccountant, hr.getListEmployee(), Accountant.class);
//		secondAccountant = (Accountant) director.chooseEmployee(secondAccountant, hr.getListEmployee(), Accountant.class);
	}

	// TODO: 24.11.2020 задача не возвращать null, а что возвращает директор?
	private <T extends Employee> Optional<T> getOptional(T employee) {
		return Optional.ofNullable(employee);
	}
}
