package task2;

import java.util.List;
import java.util.Random;

public class Director extends OfficeWorker{

	public Director(String fName, String lName) {
		this.fName = fName;
		this.lName = lName;
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
