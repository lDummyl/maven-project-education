package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Director{

	private Person person;
	String character;
	Random random = new Random();

	public Director(Person person) {
		this.person = person;
	}

	public <T extends OfficeWorker> OfficeWorker invite(List<T> filteredWorkers){
		int index = random.nextInt(filteredWorkers.size());
		return filteredWorkers.get(index);
	}

	public <T extends OfficeWorker>List<T> invite(List<? extends T> filteredWorkers, int qty) throws Exception {
		if(filteredWorkers.size() < qty){
			throw new Exception("Need to recruit more employees");
		}else {
			List<T> accepted = new ArrayList<>();
			for (int i = 0; i < qty; i++){
				int index = random.nextInt(filteredWorkers.size());
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
