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

	// TODO: 22.11.2020 все то же самое изучай дженерики
	public <T extends Employee> Optional<T> chooseEmployee(Map<Class<?>, List<Employee>> employees, Class<T> employeeClass) {
		List<Employee> tempList = employees.get(employeeClass);
		if (tempList != null && tempList.size() >= enoughToDecide) {
			randomChoose = new Random();
			Employee tempEmployee = tempList.get(randomChoose.nextInt(employees.size()));
			tempList.remove(tempEmployee); // удаляем работника который уже выбран
			if (employeeClass.isInstance(tempEmployee)) {  // Проверяем является ли tempEmployee экземпляром T? Да проверяем потому что ниже
				return Optional.of(employeeClass.cast(tempEmployee)); // Равносильно ли это даункасту? да это он и есть с той разницей что он в одном месте, а не размазан везде по коду, где используется директор.
			} else {
				throw new IllegalStateException("WTF?");
			}
		}
		return Optional.empty();// вметсо null лучше возвращать Optional.empty() почитай, подумай как
	}



	public static void main(String[] args) {
		Director director = new Director(1);

		// TODO: 24.11.2020 увы мы не можем быть в этой реализации на 100 % уверены что когда получаем мапу в ней напротив ключей именно те зачения что нужно
		HashMap<Class<?>, List<Employee>> map = new HashMap<>();
		map.put(Secretary.class, new ArrayList<>(Arrays.asList(new Lawyer())));
		map.put(Security.class, Arrays.asList(new Accountant()));

		Optional<Secretary> optionalSecretary = director.chooseEmployee(map, Secretary.class);
		if (optionalSecretary.isPresent()) {
			Secretary secretary = optionalSecretary.get();
		}


	}

}
