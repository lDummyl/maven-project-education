package task2;

import java.util.ArrayList;
import java.util.List;

// TODO: 5/20/20 пора повыносить в отдельные фаилы эти классы. Hint добавь модификатор public и тогда через alt+Enter это будет легко сделать.
public class Hr extends OfficeWorker{

	public Hr(String name) {
		this.name = name;
	}

	// TODO: 5/18/20 в условии все немного иначе, рандомное решение принимает директор. ХР проводит интервью с каждым кондидатом и отбирает подходящих или отсеивает.
	public List<OfficeWorker> filterOfficeWorker (List<OfficeWorker> officeWorkers){
		List<OfficeWorker> approveWorkers = new ArrayList<>();
		for (int i=0; i<officeWorkers.size(); i++) {
			if(officeWorkers.get(i).getSkill() > 4){
				approveWorkers.add(officeWorkers.get(i));
			}
		}
		return approveWorkers;
	}

	@Override
	public String toString() {
		return "Hr{" +
				"name='" + name + '\'' +
				'}';
	}
}
