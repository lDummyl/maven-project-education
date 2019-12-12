package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();

		HR hr = new HR();
		office.inviteHr(hr);

		Secretary alla = new Secretary("Alla");
		Secretary zina = new Secretary("Zina");
		Secretary oleg = new Secretary("Oleg");
		List<Secretary> secretaries = new ArrayList<>();
		secretaries.add(alla);
		secretaries.add(zina);
		secretaries.add(oleg);
		secretaries.add(new Secretary("Victor"));

		Manager manager = new Manager();
		office.inviteManager(manager);

		Director director = new Director();
		for (Secretary secretary : secretaries) {      // iter
			office.invitePeople(secretary);
		}

		System.out.println(office.manager.kpis);


		office.prepareList(hr);
		office.appealDirector(hr);
		office.createTable();
		office.chooseDirector(director);
	}
}
