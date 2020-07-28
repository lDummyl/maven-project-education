package task1;

import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@ToString
public class Name {

	String firstName;
	String lastName;

	static List<String> names = Arrays.asList("Ivan", "Fedor", "Stepan", "Sergey");

	static List<String> lastNames = Arrays.asList("Ivanov", "Fedorov", "Stepanov", "Sergeev");
	Random random = new Random();

	public Name(String firstName, String lastName) {
//		List<Integer> collect = IntStream.range(0, 10).boxed().collect(Collectors.toList());
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Name() {
		firstName = names.get(random.nextInt(names.size()));
		lastName = lastNames.get(random.nextInt(lastNames.size()));
	}
}

