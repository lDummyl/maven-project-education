package task2;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;
import java.util.*;

public class Office {

	/*
	Secretary secretary;

	Director director;

	Hr hr;
	*/

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

//	Director director = new Director();
// 	Hr hr = new Hr();

	ArrayList<Object> incoming = new ArrayList<Object>();

	int countSecr = 0;

	void invitePeaople(Object human){      //претенденты приходят по одному

		incoming.add(human);
		System.out.println("Секретарь " + ++countSecr + " " + human);
	}

	ArrayList<Object> getInvitePeaople(){
		return incoming;
	}
}

class Secretary {
}

class Director  {
	ArrayList<Object> incomingDir;
	Random choice = new Random();
	int randomIndex=0;

	public void directorsChoice(ArrayList<Object> incomingDir){  //дир выбрирает секретаря

		this.incomingDir = incomingDir;
		randomIndex =  choice.nextInt(this.incomingDir.size());
	}

	public Object directorsDecision()  {        //озвучивает решение
		return incomingDir.get(randomIndex);
	}
}

class Hr {
	ArrayList<Object> listJobSeekers;

	void setJobSeekers(ArrayList<Object> listJobSeekers){    //Hr принял секретарей

        this.listJobSeekers = listJobSeekers;
		IntStream.range(0,10).forEach(i ->this.listJobSeekers.add(new Secretary()));  //познакомился
	}

	ArrayList<Object> getJobSeeker(){    //отправил список
		return listJobSeekers;
	}
}