package task2;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.IntStream;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

public class Main {
	public static void main(String[] args) {

        ArrayList<Object> secretaries = new ArrayList<Object>();
		Office office = new Office();
		Director director = new Director();
		Hr hr = new Hr();

		hr.setJobSeekers(secretaries);  //hr встречается с секретарями

		IntStream.range(0,10).forEach(i -> office.invitePeaople(hr.getJobSeeker().get(i)));  //передаем в офис по одному секретарю

		director.directorsChoice(office.getInvitePeaople());  //дир принял всех секретарей

		System.out.println("Решение директора: секретарь " + (director.randomIndex+1) + " - " + director.directorsDecision());   //решение директора

	}
}
