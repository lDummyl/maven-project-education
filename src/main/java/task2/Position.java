package task2;

import task1.Person;

//class Name {
//	String firstName;
//	String lastName;
//	public Name(String firstName, String lastName) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//}
public class Position extends Person {
	String position;
	Position(String position){
		this.position = position;
	}


	public static void main(String[] args) {
		Secretary secretary = new Secretary();
		System.out.println("secretary.name = " + secretary.name);
	}
}
class Secretary extends Person{

//	public Secretary() {
//		super();
//	}
}
