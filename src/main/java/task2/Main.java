package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {

	    createSecretary(10);

	    Hr hr = new Hr();
	    Director director = new Director();
        Office office = new Office();


    }

    public static void createSecretary(int secretarialJobs){
	    List<Secretary> secretaries = new ArrayList<>();
	    for(int i = 0; i<secretarialJobs; i++){
	        secretaries.add(new Secretary());
        }

    }
}
