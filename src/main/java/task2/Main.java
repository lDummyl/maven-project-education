package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();
		HR hr = new HR();
		List<Secretary> secretaries = new ArrayList<>();

		office.inviteHr0(hr);  //делает "Please, input the number of new employees: "

		Scanner inputEmployees = new Scanner(System.in);
		int inEmployees = inputEmployees.nextInt();

		office.inviteHr(hr, inEmployees); // делает "HR: "Manager A, look at the list of 6 employee and fill up their KPI" "

		for (int i = 1; i <= inEmployees; i++){
			Secretary i = new Secretary(i);
			secretaries.add(i);
		}

		/*Secretary alla = new Secretary("Alla");
		Secretary zina = new Secretary("Zina");
		Secretary oleg = new Secretary("Oleg");

		secretaries.add(alla);
		secretaries.add(zina);
		secretaries.add(oleg);
		secretaries.add(new Secretary("Victor"));*/

		Manager manager = new Manager();
		office.inviteManager(manager);

		Director director = new Director();
		for (Secretary secretary : secretaries) {      // iter
			office.invitePeople(secretary);
		}

		System.out.println(office.manager.kpis);  // to output the string: "{Victor= , Zina= , Oleg=  , Alla= }"


		office.createTable();
		office.chooseDirector(director);
		office.applyBonus();
	}
}
