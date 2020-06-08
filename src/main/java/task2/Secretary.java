package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.Random;

public class Secretary extends Person
{
	public Secretary(Name name, Age age) {
		super(name,age);
	}

	public boolean interview(Secretary secretary) {
		return super.interview(secretary);
	}
}
