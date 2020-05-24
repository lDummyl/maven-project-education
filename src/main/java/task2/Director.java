package task2;

import task1.Person;

import java.util.List;
import java.util.Random;

public class Director extends OfficeWorker{

	private Person person;

	public Director(Person person) {
		this.person = person;
	}

	// TODO: 5/20/20 почему ты думаешь что директор может быть только один? Сингольтон это конечно круто, но вот тебе модификаця задачи: Нужно создать 2 офиса и в них разный персонал, конкуренты.



	public OfficeWorker invite(List<OfficeWorker> officeWorkers){
		Random random = new Random();
			int index = random.nextInt(officeWorkers.size());
			return officeWorkers.get(index);
	}

	@Override
	public String toString() {
		return "Director{" +
				"fName='" + fName + '\'' +
				", lName='" + lName + '\'' +
				'}';
	}
}
