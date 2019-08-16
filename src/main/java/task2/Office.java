package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
    Secretary workingSecretary;
    String nameOffice;

	Director director = new Director(this);   //зачем здесь параметр this не оч понятно?
	Hr hr = new Hr("Аделаида Марковна");

    public Office(){};

	public Office(String nameOffice, Object workingSecretary ){  //конструктор для распределения секретарей по офисам
	    this.nameOffice = nameOffice;

       if (workingSecretary instanceof Secretary)
	    this.workingSecretary = (Secretary)workingSecretary;
	}

	void invitePeople(Object human) {      //претенденты приходят по одному
		if (human instanceof WantAWork) {      //с помощью оператора instanceof убеждаемся, что обьекты human может быть приведен типу(интерфейсу) WantAWork
			List<WantAWork> currentCandidates = hr.considerCandidate((WantAWork) human);  //создаем спсок текущих кандидатов и присваивам ему список от Hr с параметром human, который приведен к типу WantAWork
			secretary = director.chooseSecretary(currentCandidates);  //присваиваем объекту secretary выбранного секретаря которого выбрал директор
		}
	}

	void workingOffice() {
        System.out.println(this.nameOffice + " - здесь работает " + workingSecretary);
    }

}

class Secretary implements WantAWork {  //implements это ключевое слово, предназначенное для реализации интерфейса

	String name;
	Office office;

	public Secretary(String name) {
		this.name = name;
	}

    public Secretary(String name, Office office) { this.name = name; this.office = office; }

	@Override
	public String toString() {
		return "Секретарь " + name;   //делаем приписку к имени секретаря
	}

	@Override                        //для чего здесь переопределение (@Override)
	public boolean passInterview() {
		return true;
	}
}

class Director {

	final Office myOffice;                 //myOffice константа?
//	final DataMy constant = new DataMy(6);
	final int enoughCandidatesToDecide = 4;
	Random random = new Random();

	public Director(Office myOffice) {
		this.myOffice = myOffice;
	}

	public Secretary chooseSecretary(List<WantAWork> currentCandidates) {       //Дир выбрает секретаря из списка Hr
		if (currentCandidates.size() < enoughCandidatesToDecide) return null;    //если список Hr меньше достаточного кол-ва кандидатов, то возвращаем null
//		constant.i = 10;

		WantAWork wantAWork = currentCandidates.get(random.nextInt(currentCandidates.size()));    //создаем объект WantAWork и присваеваем ему случайно выбранного кандидата из списка Hr

		if (wantAWork instanceof Secretary) {     //проверяем на совместимость типа к объкту wantAWork
			return (Secretary) wantAWork;         //тогда возвращаем wantAWork приведенный к типу Secretary
		} else {
			throw new RuntimeException("Что это вы, "+ myOffice.hr.name +",  мне подсовываете " + wantAWork.getClass() + " вместо " + Secretary.class); //иначе создается исключение(в виде ошибки).. срабатывает я так понял, если wantAWork и Secretary не совместимы
 		}
	}

//	private class DataMy {
//		int i;
//
//		public DataMy(int i) {
//			this.i = i;
//		}
//	}
}

class Hr{

	List<WantAWork> listJobSeekers = new ArrayList<>();
	String name;

	public Hr(String name) {
		this.name = name;
	}

	public List<WantAWork> considerCandidate(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел
		if (candidate.passInterview()) {               //если кандидат прошел интерьвью passInterview() возвращает true
			listJobSeekers.add(candidate);             //и в список listJobSeekers добавляется кандидат
		}
		return listJobSeekers;                         //возвращаем список
	}
}
