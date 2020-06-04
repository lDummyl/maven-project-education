package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Director extends Person
{

	public Director(Name name, Age age) {
		super(name, age);
	}

	public Director(String name) {
		super(new Name(name, ""), new Age());
	}

	public void setName(Name name) {
		this.name = name;
	}
	public Name getName() {
		return name;
	}
	public void setAge(Age age)
	{
		this.age = age;
	}
	public Age getAge (){return age;}

	 ArrayList <String> listOfActions = new ArrayList<>();
	{
		listOfActions.add("Кандитатов слишком много!");
		listOfActions.add("У меня нет на это времени!");
		listOfActions.add("Список необходимо уменьшить");
		listOfActions.add("Кандидат выбран");
	}

    //задумка была такова, что в случае, если список больше определенного значения, данный список должен передаваться обратно hr, который его отрабатывает
	// и возвращает в сокращенном варианте. но метод passInterview у меня, конечно, не срабатывает и ничего не меняется. В общем, я совсем запуталась.
	public Secretary select (List <Secretary> list) {
			if (list.size() > 20) {
				Hr.passInterview(list);
				System.out.println(listOfActions.get(0));
			}
			else if (list.size() > 10) {
				System.out.println(listOfActions.get(1));
				Hr.passInterview(list);
			}
			else if (list.size() > 5) {
				System.out.println(listOfActions.get(2));
				Hr.passInterview(list);
			}
			else if (list.size() <= 3) {
				System.out.println(listOfActions.get(3));
			}
			return null;
		}

	/*public Secretary select (List <Secretary> list)
	{
		while (list.size() != 3)
		{
			Hr.passInterview(list);
		}
		return null;
	}
	 */
	}
