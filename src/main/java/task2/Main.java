package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import javax.crypto.SecretKey;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();

		HR list = new HR();
		office.giveList(list);

		Secretary alla = new Secretary("Alla");
		office.invitePeople(alla);

		Secretary zina = new Secretary("Zina");
		office.invitePeople(zina);

		Secretary oleg = new Secretary("Oleg");
		office.invitePeople(oleg);

		Manager manager = new Manager();
		office.listKPI(manager);

		office.prepareList(list);
		System.out.println("");

		office.appealDirector(list);

		office.createTable(list);

		Director director = new Director();
		office.chooseDirector(director);


	}
}
