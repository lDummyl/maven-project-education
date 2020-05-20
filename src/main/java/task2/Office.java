package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {


	// TODO: 5/18/20 эти поля должны получить свои объекты.
	Director director = Director.getDirector();

	Hr hr = Hr.getHr();

	Secretary secretary = director.invite(hr.filterSecretary(Main.createSecretary(50)));

	/*
	Код я причесал, но он мне очень не нравится по той причине, что он перестал быть гибким. Если раньше я все ссылочные
	типы мог указать через общий интерфейс OfficeWorker и мог создать нового офисного работника (например, программиста),
	список которых hr так же предлагал бы директору, то теперь мне нужно для этого писать отдельный метод.
	Получилось так потому, что я ввел критерий отсева. У класса Secretary теперь есть поле skill, по которому hr фильтрует
	кандидатов. И если я на вход метода фильтра работников подам список OfficeWorker'ов, то не смогу вытащить эту переменную, чтобы провести сравнение.

	 */






	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(Object human){

	}

}

class Secretary implements OfficeWorker{
	String name;
	int skill;

	public Secretary(String name, int skill) {

		this.name = name;
		this.skill = skill;
	}

	public void sendMail() {
		System.out.println("Mail has been sent");
	}

	public int getSkill() {
		return skill;
	}

	@Override
	public String toString() {
		return name;
	}
}

class Director implements OfficeWorker{

	private static Director director;

	private Director(){}

	public static Director getDirector(){
		if(director == null){
			director = new Director();
		}
		return director;
	}


	public Secretary invite(List<Secretary> secretaries){
		Random random = new Random();
		int index = random.nextInt(secretaries.size());
		System.out.println(secretaries.get(index)+", You are accepted!");
		return secretaries.get(index);
	}

}

class Hr implements OfficeWorker{

	private static Hr hr;

	private Hr() {

	}


	public static Hr getHr(){
		if(hr == null){
			hr = new Hr();
		}
		return hr;
	}


	// TODO: 5/18/20 в условии все немного иначе, рандомное решение принимает директор. ХР проводит интервью с каждым кондидатом и отбирает подходящих или отсеивает.
	public List<Secretary> filterSecretary (List<Secretary> secretaries){
		List<Secretary> approveSecretary = new ArrayList<>();
		for (int i=0; i<secretaries.size(); i++) {
			if(secretaries.get(i).getSkill() > 4){
				approveSecretary.add(secretaries.get(i));
			}
		}
		return approveSecretary;
	}


}
