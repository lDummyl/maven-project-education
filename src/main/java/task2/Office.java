package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Office {

	public Secretary secretarialChoice(Director director, Hr hr, List<Secretary> secretaries){
		Random random = new Random();
		boolean flag = true;
		while (flag){
			int result = random.nextInt(10);
			if(result > 5 && result < 10){
				flag = false;
				return (Secretary) director.invite(hr.proposeSecretary(secretaries));
			}
		}
	}


	// TODO: 5/18/20 эти поля должны получить свои объекты.

	Secretary secretary = secretarialChoice(Director.getDirector(), Hr.getHr(), );

	Director director = Director.getDirector();

	Hr hr = Hr.getHr();


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


	public OfficeWorker invite(OfficeWorker officeWorker){

		System.out.println(officeWorker+", You are accepted!");
		return officeWorker;
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
	public List<OfficeWorker> proposeSecretary (List<Secretary> secretaries){
		List<OfficeWorker> approveSecretary = new ArrayList<>();
		for (int i=0; i<secretaries.size(); i++) {
			if(secretaries.get(i).getSkill() > 4){
				approveSecretary.add(secretaries.get(i));
			}
		}
		return approveSecretary;
	}


}
