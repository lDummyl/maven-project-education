package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

// TODO: 5/20/20 пора повыносить в отдельные фаилы эти классы. Hint добавь модификатор public и тогда через alt+Enter это будет легко сделать.
public class Hr{

	private Person person;

	public Hr(Person person) {
		this.person = person;
	}

	// TODO: 5/18/20 в условии все немного иначе, рандомное решение принимает директор. ХР проводит интервью с каждым кондидатом и отбирает подходящих или отсеивает.
	public List<Secretary> filterSecretary (List<Secretary> secretaries){
		List<Secretary> approveSecretary = new ArrayList<>();
		for (int i=0; i<20; i++) {
				approveSecretary.add(secretaries.get(i));
		}
		return approveSecretary;
	}

	public List<Security> filterSecurity (List<Security> securities){
		List<Security> approveSecurity = new ArrayList<>();
		for (int i=0; i<20; i++) {
			approveSecurity.add(securities.get(i));
		}
		return approveSecurity;
	}

	public List<Jurist> filterJurist (List<Jurist> jurists){
		List<Jurist> approveJurist = new ArrayList<>();
		for (int i=0; i<20; i++) {
			approveJurist.add(jurists.get(i));
		}
		return approveJurist;
	}

	public List<Accountant> filterAccountant (List<Accountant> accountants){
		List<Accountant> approveAccountant = new ArrayList<>();
		for (int i=0; i<20; i++) {
			approveAccountant.add(accountants.get(i));
		}
		return approveAccountant;
	}

	@Override
	public String toString() {
		return "Hr{" +
				person +
				'}';
	}
}
