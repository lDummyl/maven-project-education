package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		Office office = new Office();
		System.out.println(office.secretary);

    }

    public static List<Secretary> createSecretary(int secretarialJobs){
		Random random = new Random();
		List<Secretary> secretaries = new ArrayList<>();
	    for(int i = 0; i<secretarialJobs; i++){
	        secretaries.add(new Secretary("Secretary"+i, random.nextInt(10)));
        }
		return secretaries;
    }
}
