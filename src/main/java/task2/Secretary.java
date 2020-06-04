package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.Random;

public class Secretary extends Person
{
	public static int secretaryCount = 0;
	public Secretary(Name name, Age age) {
		super(name,age);
	}
	public void count ()
	{
		secretaryCount ++;
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


	public boolean interview(Secretary secretary) {
		return super.interview(secretary);
	}
}
