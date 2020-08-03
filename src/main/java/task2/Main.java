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
		Office appleInc = new Office(director, hr);
		Office amazonInc = null;
		while (hr.checkNumberOfSecretaries()) {
			appleInc.invitePeople(new Secretary(new Name(), new BirthDate()));
		}
		System.out.println(appleInc.secretary);
		// TODO: 8/3/20 странно что директор выбирает секретаря вне офиса, могу себе представить,
		//  интервью на лужайке в кампусе или по дороге в из офиса, но проблема только в том,
		//  что конечная проверка должна быть такой

		if (appleInc.secretary != null){
			System.out.println("Everything's fine");
		} else {
			System.out.println("Not good at all");
		}

		// TODO: 8/3/20 сделаем так офисов будет 2, работают там все разыне сотрудники, дерзай

	}
}
