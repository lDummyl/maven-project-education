package task2;

import java.util.List;

public class Office {



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

	public void sendMail() {
		System.out.println("Mail has been sent");
	}

	@Override
	public void work() {
		sendMail();
	}
}

class Director implements OfficeWorker{


	@Override
	public void work() {

	}


}

class Hr implements OfficeWorker{

	public Secretary propose (List<Secretary> secretaryList){

	}

	@Override
	public void work() {

	}
}
