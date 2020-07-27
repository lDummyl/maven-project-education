package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.BirthDate;
import task1.Name;

public class Main {
	public static void main(String[] args) {
		// TODO: 7/27/20 напиши тестовый сценарий на все происходящее содание объектов трудойстройство, проверка
		Director director = new Director();
		Hr hr = new Hr();
		Office office = new Office();

		office.invitePeople(director);
		office.invitePeople(hr);

		while (!office.fullOffice()) {
			office.invitePeople(new Secretary(new Name(), new BirthDate()));
		}
		office.printChoice();
	}
}
