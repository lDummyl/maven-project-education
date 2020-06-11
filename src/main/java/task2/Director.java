package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director{

	private Person person;
	Random random = new Random();

	// TODO: 6/11/20 смотрю больше всех работает директор, а это только кадровый вопрос.
	public Director(Person person) {
		this.person = person;
	}

	public <T extends OfficeWorker> void invite(Office office, List<T> filteredWorkers, int qty) {
		int size = filteredWorkers.size();
		if (size > qty) {
			for (int i = 0; i < qty; i++) {
				int index = random.nextInt(size);
				office.setOfficeWorkers(filteredWorkers.get(index));
			}
		} else {
			throw new RuntimeException("Need to recruit more employees Expected:" + qty + " but was: " + size);
		}
	}

	public <T extends OfficeWorker> void invite(Office office, List<? extends OfficeWorker> ...filteredWorkers) {
		int size = filteredWorkers.length;
		for (int i = 0; i < size; i++) {
			int index = random.nextInt(filteredWorkers[i].size());
			office.setOfficeWorkers(filteredWorkers[i].get(index));
		}
	}


	@Override
	public String toString() {
		return "Director{" +
				person +
				'}';
	}
}
