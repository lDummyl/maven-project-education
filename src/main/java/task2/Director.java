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

	public <T extends OfficeWorker> void invite(Office office, List<T> filteredWorkers, int qty) {
		int size = filteredWorkers.size();
		if (size > qty) {
			List<T> accepted = new ArrayList<>();
			for (int i = 0; i < qty; i++) {
				int index = random.nextInt(size);
				accepted.add(filteredWorkers.get(index));
			}if(accepted.get(0) instanceof Secretary){
				office.setSecretaries((List<Secretary>) accepted);
			}else if (accepted.get(0) instanceof Security){
				office.setSecurities((List<Security>) accepted);
			}else if (accepted.get(0) instanceof Jurist){
				office.setJurists((List<Jurist>) accepted);
			}else if (accepted.get(0) instanceof Accountant){
				office.setAccountants((List<Accountant>) accepted);
			}
		} else {
			throw new RuntimeException("Need to recruit more employees Expected:" + qty + " but was: " + size);
		}
	}

	public <T extends OfficeWorker> void invite(Office office, List<? extends OfficeWorker> ...filteredWorkers) {
		int size = filteredWorkers.length;
			for (int i = 0; i < size; i++) {
				List<T> accepted = new ArrayList<>();
				int index = random.nextInt(filteredWorkers[i].size());
				accepted.add((T) filteredWorkers[i].get(index));
				if (accepted.get(0) instanceof Secretary) {
					office.setSecretaries((List<Secretary>) accepted);
				} else if (accepted.get(0) instanceof Security) {
					office.setSecurities((List<Security>) accepted);
				} else if (accepted.get(0) instanceof Jurist) {
					office.setJurists((List<Jurist>) accepted);
				} else if (accepted.get(0) instanceof Accountant) {
					office.setAccountants((List<Accountant>) accepted);
				}
			}
		}


	@Override
	public String toString() {
		return "Director{" +
				person +
				'}';
	}
}
