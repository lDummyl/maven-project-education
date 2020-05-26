package task2;

import task1.Age;
import task1.Name;
import task1.Person;

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
}
