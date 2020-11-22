package task2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Director {

	private Random randomChoose;


	// TODO: 22.11.2020 все то же самое изучай дженерики
	public <T extends Employee> T chooseEmployee(Map<Class<?>, List<Employee>> employees, Class<T> employeeClass) {
		List<Employee> tempList = employees.get(employeeClass);
		if (tempList != null && tempList.size() >= 10) {
			randomChoose = new Random();
			Employee tempEmployee = tempList.get(randomChoose.nextInt(employees.size()));
			tempList.remove(tempEmployee); // удаляем работника который уже выбран
			employees.put(employeeClass, tempList); // TODO: 22.11.2020  лист и так изменится повтроно его класть не нужно для этого, потому что ты получаешь не лист, а ссылку на него
			if (employeeClass.isInstance(employeeClass)) {
				return employeeClass.cast(tempEmployee);
			} else{
				throw new IllegalStateException("WTF?");
			}
		}
		return null;// вметсо null лучше возвращать Optional.empty() почитай, подумай как
	}

	public static void main(String[] args) {
		Director director = new Director();

		HashMap<Class<?>, List<Employee>> map = new HashMap<>();
		Secretary secretary = director.chooseEmployee(map, Secretary.class);
		Lawyer lawyer = director.chooseEmployee(map, Lawyer.class);

	}

}
