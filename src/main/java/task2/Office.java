package task2;

import java.util.List;
import java.util.Random;

public class Office {

	public void work(Director director, Hr hr, List<OfficeWorker> officeWorkers){
		Random random = new Random();
		boolean flag = true;
		while (flag){
			int result = random.nextInt(10);
			if(result > 5 && result < 10){
				flag = false;
				director.invite(hr.proposeWorker(officeWorkers));
			}
		}
	}


	// TODO: 5/18/20 эти поля должны получить свои объекты.
	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(Object human){

	}

}

class Secretary implements OfficeWorker{
	String name;

	public Secretary(String name) {
		this.name = name;
	}

	public void sendMail() {
		System.out.println("Mail has been sent");
	}

	@Override
	public String toString() {
		return name;
	}
}

class Director implements OfficeWorker{

	public void invite(OfficeWorker officeWorker){
		System.out.println(officeWorker+", You are accepted!");
	}

}

class Hr implements OfficeWorker{

	Random random = new Random();

	// TODO: 5/18/20 в условии все немного иначе, рандомное решение принимает директор. ХР проводит интервью с каждым кондидатом и отбирает подходящих или отсеивает.
	public OfficeWorker proposeWorker (List<OfficeWorker> officeWorkers){
		return officeWorkers.get(random.nextInt(officeWorkers.size()));
	}

}
