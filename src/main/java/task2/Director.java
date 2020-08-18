package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director extends Person {

	public Director(Name name, Age age) {
		super(name, age);
	}
	public Director (Name name) {
		super(name);
	}

	ArrayList<String> listOfActions = new ArrayList<>();

	{
		listOfActions.add("Кандитатов слишком много!");
		listOfActions.add("У меня нет на это времени!");
		listOfActions.add("Список необходимо уменьшить");
		listOfActions.add("Кандидат выбран");
	}

	public Secretary select(Office office, Hr hr, List<Secretary> list) {
		while (list.size() > 5) {
			list = hr.passInterview(list);
			if (list.size() > 20) {
				System.out.println(listOfActions.get(0));
			}
			if (list.size() > 10) {
				System.out.println(listOfActions.get(1));
			}
			if (list.size() > 5) {
				System.out.println(listOfActions.get(2));
			}
		}
		if (list.size() < 5) {
			System.out.println(listOfActions.get(3));
			Random random = new Random();
			Secretary secretary = list.get(random.nextInt(list.size()));
			office.invitePeople(secretary);
			return secretary;
		}
		return null;
			}

		}





