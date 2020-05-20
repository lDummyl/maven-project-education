package task2;

import java.util.List;
import java.util.Random;

public class Director extends OfficeWorker{

	public Director(String name, int skill) {
		this.name = name;
		this.skill = skill;
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
				"name='" + name + '\'' +
				'}';
	}
}
