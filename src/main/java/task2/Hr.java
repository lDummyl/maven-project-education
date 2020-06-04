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

public static List<Secretary> passInterview(List <Secretary> secretaries)
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
