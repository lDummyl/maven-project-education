package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Hr{

	private Person person;

	public Hr(Person person) {
		this.person = person;
	}

	public Object oldFilter(OfficeWorker officeWorker){
		if(officeWorker.getPerson().getAge().getYear() < 1999){
			return officeWorker;
		}
		return null;
	}

	public List<Object> filterWorker (List<Object> humans){
		if(humans.get(0) instanceof Secretary){
			List<Secretary> approvedSecretaries = new ArrayList<>();
				for (int i = 0; i < humans.size(); i++){
					approvedSecretaries.add((Secretary) oldFilter((OfficeWorker) humans.get(i)));
				}
				return approvedSecretaries;
		}

		List<Secretary> approveSecretary = new ArrayList<>();
		for (int i=0; i < secretaries.size(); i++) {
			if(secretaries.get(i).getPerson().getAge().getYear() > 1999){
				approveSecretary.add(secretaries.get(i));
			}
		}
		return approveSecretary;
	}


	public List<Secretary> filterSecretary (List<Secretary> secretaries){
		List<Secretary> approveSecretary = new ArrayList<>();
		for (int i=0; i < secretaries.size(); i++) {
			if(secretaries.get(i).getPerson().getAge().getYear() > 1999){
				approveSecretary.add(secretaries.get(i));
			}
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
