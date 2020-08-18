package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Hr extends Person
{

	public Hr(Name name, Age age) {
		super(name, age);
	}
	public Hr (Name name) {super(name);}
	// TODO: 6/4/20 не нужны тебе пока геттеры и сеттеры, только мешать будут, делай пока все поля pubic просто


	// TODO: 6/4/20 статик нужно убрать и использовать созданные объекты.

public List<Secretary> passInterview(List<Secretary> secretaries)
	{
		List <Secretary> list = new ArrayList<>();
		for (Secretary secretary : secretaries) {
			if (secretary.interview(secretary))
			{
				list.add(secretary);
			}
			else if (!secretary.interview(secretary))
			{}
		}
		return list;
	}
}
