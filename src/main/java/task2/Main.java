package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();
		HR hr = new HR();
		Manager manager = new Manager();
		Director director = new Director(5, "Viktor Ivanjch");
		Director director2 = new Director(2, "Petr Ivanjch");

		List<Secretary> secretaries = new ArrayList<>();
		List<String> names = Arrays.asList("Alla", "Zina", "Oleg", "Victor", "Olya", "Anna", "Semen", "Sasha");
		Random random = new Random();

		office.invite(hr);  //делает "Please, input the number of new employees: "

		Scanner inputEmployees = new Scanner(System.in);
		int inEmployees = inputEmployees.nextInt();

		office.invite(hr, inEmployees); // делает "HR: "Manager A, look at the list of 6 employee and fill up their KPI" "

		for (int i = 1; i <= inEmployees; i++){
			String name = names.get(random.nextInt(names.size()));
			Secretary secretary = new Secretary(name + i);
			secretaries.add(secretary);
		}


		office.invite(manager);
		office.invite(director);


		for (Secretary secretary : secretaries) {      // iter
			office.invite(secretary);
		}

		System.out.println("");
		System.out.println("KPI result: " + office.manager.kpis);  // to output the string: "{Victor= , Zina= , Oleg=  , Alla= }"
		System.out.println("Experience result: " + office.manager.expYears);
		System.out.println("");


		office.startWorkDay();
		// TODO: 1/16/20 еще подказка если начинаешь рабочий день до того как приглашаешь директора, то его може и не оказаться на месте когда он потребутея,
		//  например, чтобы раздать бонус.

	}
}
