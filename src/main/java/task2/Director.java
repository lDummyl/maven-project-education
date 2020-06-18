package task2;

import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director extends Person{

	public Director(Name name, Age age){
		super(name, age);
	}
	Random random = new Random();

	public <T extends OfficeWorker> List<T> invite(List<T> filteredWorkers, int qty) {
			int size = filteredWorkers.size();
			List<T> accepted = new ArrayList<>();
			if (size > qty) {
				for (int i = 0; i < qty; i++) {
					int index = random.nextInt(size);
					accepted.add(filteredWorkers.get(index));
				}
			} else {
				throw new RuntimeException("Need to recruit more employees Expected:" + qty + " but was: " + size);
			}
			return accepted;

	}

	@Override
	public String toString() {
		return "Director{" +
				name +
				age +
				'}';
	}
}
