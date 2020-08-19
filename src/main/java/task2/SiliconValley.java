package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Age;
import task1.Name;
import task1.PersonProvider;
import task2.Director;

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


		/*List<Object> officeWorkers = new ArrayList<>();
		officeWorkers.add(apple.director);
		officeWorkers.add(apple.hr);
		officeWorkers.add(apple.secretary);

		for (Object worker : officeWorkers) {
			System.out.println(worker);
		}

		 */

		// TODO: 6/4/20 А в офисе никого? все вопросы смотрю тут решаются, трендово конешно, но не по условию

		//System.out.println(apple.secretary != null);

	}
}

