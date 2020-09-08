package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Age;
import task1.Name;
import task1.PersonProvider;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SiliconValley {
	public static void main(String[] args) {
		//можно уточнить условия задания? наверное я их не правильно понимаю. обьекты классов Директор и HR должны создаваться в классе Офис.
		// TODO: 8/19/20 нет
		//обьекты класса офис так же создаются в классе офис?
		// TODO: 8/19/20 нет
		// но, если мне нужно протестировать корректность выполнения метода отбора секретарей в
		//main, тогла офисы нужно создавать в классе siliconValley,
		// TODO: 8/19/20 да
		// поскольку класс офис является нестатическим и никакие переменные из него без создания
		//экземпляра класса в мейне вызвать не получается. запуталась в общем


		Director steveJobs = new Director(new Name("Steve", "Jobs"), new Age(1955, 1, 24), 5);
		Director sergeyBrin = new Director(new Name("Sergey", "Brin"), new Age(1973, 7, 21), 3);
		Hr oscar = new Hr(new Name("Oscar"), new Age(LocalDate.of(1994, 4, 15)));
		Hr mark = new Hr(new Name("Mark", "Grey"), new Age(1990, 5, 11));
		Office apple = new Office(steveJobs, oscar);
		Office google = new Office(sergeyBrin, mark);
		PersonProvider personProvider = new PersonProvider();
		List<Secretary> secretaries = personProvider.getSecretaries(100);
		for (Secretary secretary : secretaries) {
			apple.invitePeople(secretary);
		}
		System.out.println(apple.secretary);




		// TODO: 6/4/20 А в офисе никого? все вопросы смотрю тут решаются, трендово конешно, но не по условию

		System.out.println(apple.secretary != null);

	}
}

