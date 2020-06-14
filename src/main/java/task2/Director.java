package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director{

	// TODO: 6/14/20 заменить на наследование
	private Person person;
	Random random = new Random();

	// TODO: 6/11/20 смотрю больше всех работает директор, а это только кадровый вопрос.
	public Director(Person person) {
		this.person = person;
	}


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
				person +
				'}';
	}
}
