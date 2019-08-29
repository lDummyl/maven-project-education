package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
	Accountant accountant;

	List<Secretary> listWorkingSecretary = new ArrayList<>();
    String nameOffice;

	Director director = new Director(this);   //зачем здесь параметр this не оч понятно?
	Hr hr = new Hr("Аделаида Марковна");

    public Office(){};

    public Office(String nameOffice){ this.nameOffice = nameOffice;};

/*	public Office(String nameOffice, Object workingSecretary ){  //конструктор для распределения секретарей по офисам
	    this.nameOffice = nameOffice;

		// TODO: 8/16/19 ну нет конечно не так, у нас нет такого способа через черный ход нанять секретаря. Все как положено через хр и директора.
		//  Кроме того конструктор не должен содержать логики(в данном случае проверка), он только инициализирует поля.
	//    if (workingSecretary instanceof Secretary)
	    this.workingSecretary = (Secretary)workingSecretary;
	}
 */

	void invitePeople(Object human) {      //претенденты приходят по одному
		if (human instanceof WantAWork) {      //с помощью оператора instanceof убеждаемся, что обьекты human может быть приведен типу(интерфейсу) WantAWork
			List<WantAWork> currentCandidates = hr.considerCandidate((WantAWork) human);  //создаем спсок текущих кандидатов и присваивам ему список от Hr с параметром human, который приведен к типу WantAWork
			secretary = director.chooseSecretary(currentCandidates);  //присваиваем объекту secretary выбранного секретаря которого выбрал директор
			accountant = director.chooseAccountant(currentCandidates);

			//	secretary.office = this;
			if(secretary != null)
				listWorkingSecretary.add(secretary);
		}
	}

	void distributeOnOffice(Secretary secretary, Office office) {
		this.secretary = secretary;
		this.secretary.office = office;

		System.out.println(this.secretary + " работает в " + this.secretary.office.nameOffice);
	}
}


