package task2;

import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Hr extends OfficeWorker{

	Person person;


	public static final int YEAR_OF_BIRTH = 2000;


	public Hr(Person person) {
		this.person = person;
	}

	public <T extends OfficeWorker>List<T> filter(List<T> officeWorkers){
		List<T> approved = new ArrayList<>();
		for(int i = 0; i < officeWorkers.size(); i++){
			if(officeWorkers.get(i).getPerson().getAge().getYear() < YEAR_OF_BIRTH){
				approved.add(officeWorkers.get(i));
			}
		}
		return approved;
	}




	@Override
	public String toString() {
		return "Hr{" +
				person +
				'}';
	}
}
