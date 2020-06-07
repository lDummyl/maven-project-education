package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director{

	private Person person;
	Random random = new Random();

	public Director(Person person) {
		this.person = person;
	}

	public <T extends OfficeWorker> OfficeWorker invite(List<T> filteredWorkers){
		int index = random.nextInt(filteredWorkers.size());
		return filteredWorkers.get(index);
	}

	public <T extends OfficeWorker> List<T> invite(List<? extends T> filteredWorkers, int qty) {
		int size = filteredWorkers.size();
		if (size < qty) {
			throw new RuntimeException("Need to recruit more employees Expected:" + qty + " but was: " + size);
		} else {
			List<T> accepted = new ArrayList<>();
			for (int i = 0; i < qty; i++) {
				int index = random.nextInt(size);
				accepted.add(filteredWorkers.get(index));
			}
			return accepted;
		}
	}

	@Override
	public String toString() {
		return "Director{" +
				person +
				'}';
	}
}
