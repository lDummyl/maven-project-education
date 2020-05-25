package task2;

import task1.Person;

import java.util.List;
import java.util.Random;

public class Director{

	private Person person;

	public Director(Person person) {
		this.person = person;
	}




	public Secretary inviteSecretary(List<Secretary> secretaries){
		Random random = new Random();
			int index = random.nextInt(secretaries.size());
			return secretaries.get(index);
	}

	public Security inviteSecurity(List<Security> securities){
		Random random = new Random();
		int index = random.nextInt(securities.size());
		return securities.get(index);
	}

	public Jurist inviteJurist(List<Jurist> jurists){
		Random random = new Random();
		int index = random.nextInt(jurists.size());
		return jurists.get(index);
	}

	public Accountant inviteAccountant(List<Accountant> accountants){
		Random random = new Random();
		int index = random.nextInt(accountants.size());
		return accountants.get(index);
	}

	@Override
	public String toString() {
		return "Director{" +
				person +
				'}';
	}
}
