package task1;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ToString
public class Name {

	String firstName;
	String lastName;

	static List<String> names =  Arrays.asList("Ivan", "Fedor");
	static List<String> lastNames =  Arrays.asList("Ivanov", "Fedorov");
	Random random = new Random();
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Name() {
		firstName = names.get(random.nextInt(names.size()));
		lastName = lastNames.get(random.nextInt(lastNames.size()));
	}
}

