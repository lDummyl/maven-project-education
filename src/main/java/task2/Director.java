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
		listOfActions.add("Список кандидатов необходимо уменьшить");
		listOfActions.add("Кандидат выбран");
	}

	/*public Secretary select (List <Secretary> list)
	{
		if (list.size() > 50)
		{
			listOfActions.get(0);
		}
		return Secretary;
	}

	 */



}
