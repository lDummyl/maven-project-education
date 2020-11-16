package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.BirthDate;
import task1.Name;

public class Main {
	public static void main(String[] args) {

		Director director = new Director();
		Hr hr = new Hr();
		Office appleInc = new Office(director, hr);
		Office amazonInc = null;
		while (hr.doesntTired()) {
			appleInc.invitePeople(new Secretary(new Name(), new BirthDate(), new Skills()));
			appleInc.invitePeople(new Lawyer(new Name(), new BirthDate(), new Skills()));
		}
		System.out.println(appleInc.secretary);
		System.out.println(appleInc.lawyer);

		if (appleInc.secretary != null){
			System.out.println("Everything's fine");
		} else {
			System.out.println("Not good at all");
		}
		// TODO: 8/3/20 прекрасно! теперь, когда есть готовый механизм, расширим его функционал,
		//  пусть будет еще юрист, 2 бухгалтера и охранник в каждом офисе и мы будем устраивать всех, кроме кадрового ядра,
		//  на конкурсной основе. И пусть тепеь прохождение интервью зависит и от сотрудника нежели от настроения HR.

	}
}
