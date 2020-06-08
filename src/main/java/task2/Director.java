package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Director extends Person {

	public Director(Name name, Age age) {
		super(name, age);
	}

	ArrayList<String> listOfActions = new ArrayList<>();

	{
		listOfActions.add("Кандитатов слишком много!");
		listOfActions.add("У меня нет на это времени!");
		listOfActions.add("Список необходимо уменьшить");
		listOfActions.add("Кандидат выбран");
	}

	public boolean checkList(List<Secretary> list) {
		if (list.size() > 20) {
			System.out.println(listOfActions.get(0));
			return false;
		} else if (list.size() > 10) {
			System.out.println(listOfActions.get(1));
			return false;
		} else if (list.size() > 5) {
			System.out.println(listOfActions.get(2));
			return false;
		} else if (list.size() <= 3) {
			System.out.println(listOfActions.get(3));
			return true;
		}
		return false;
	}
}