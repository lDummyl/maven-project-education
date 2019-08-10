package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();

		ArrayList<Secretary> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Oleg"));
		secretaries.add(new Secretary("Zina"));
		secretaries.add(new Secretary("Ivan"));

		for (Secretary candidate : secretaries) {
			office.invitePeaople(candidate);
		}
	}
}
