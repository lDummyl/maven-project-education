package task2;

import java.util.*;

public class Director {

	private Random randomChoose;
	private int enoughToDecide;

	public Director(int enoughToDecide) {
		this.enoughToDecide = enoughToDecide;
	}

	public Director() {
		this.enoughToDecide = 10;
	}

	public <T extends Employee> Optional<T> chooseEmployee(Map<Class<?>, List<Employee>> employees, Class<T> employeeClass) {
		List<Employee> tempList = employees.get(employeeClass);
		if (tempList != null && tempList.size() >= enoughToDecide) {
			randomChoose = new Random();
			Employee tempEmployee = tempList.get(randomChoose.nextInt(employees.size()));
			tempList.remove(tempEmployee);
			if (employeeClass.isInstance(tempEmployee)) {
				return Optional.of(employeeClass.cast(tempEmployee));
			} else {
				throw new IllegalStateException("WTF?");
			}
		}
		return Optional.empty();
	}
}
