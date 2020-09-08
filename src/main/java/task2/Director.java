package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director extends Person {
	final int enoughCandidatesToDecide;


	public Director(Name name, Age age, int enoughCandidatesToDecide) {
		super(name, age);
		this.enoughCandidatesToDecide = enoughCandidatesToDecide;
	}

	ArrayList<String> listOfActions = new ArrayList<>();

	{
		listOfActions.add("Кандитатов слишком много!");
		listOfActions.add("У меня нет на это времени!");
		listOfActions.add("Список необходимо уменьшить");
		listOfActions.add("Кандидат выбран");
	}

	public Secretary select(List<Secretary> list) {
		if (list.size() < enoughCandidatesToDecide)
		{
			return null;
		}
		Random random = new Random();
		return list.get(random.nextInt(list.size()));

	}
}





