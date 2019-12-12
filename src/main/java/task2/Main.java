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
		Secretary zina = new Secretary("Zina");
		Secretary oleg = new Secretary("Oleg");
		Manager manager = new Manager();
		Director director = new Director();

		office.invitePeople(alla);
		office.invitePeople(zina);
		office.invitePeople(oleg);
		office.listKPI(manager);
		office.prepareList(list);
		office.appealDirector(list);
		office.createTable(list);
		office.chooseDirector(director);


	}
}
