package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Person;
import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


	// TODO: 6/11/20 сделай  main макс в 10 строк и каждый метод макс в 10 строк
	// TODO: 6/11/20 А что под снос попал 2й офис? следующее требование не отменяет предыдущего.
	// TODO: 6/14/20 ну а теперь пусть будет 3 офиса с 2мя, 3мя и 4мя бухгалтерами, метод main по прежнему не более 10 сток. 
	public static void main(String[] args) throws Exception {
		BusinessCenter businessCenter = new BusinessCenter();
		List<Office> sova = businessCenter.createOffices( 2, 3, 4);
        for (Office office : sova){
            doStuff(office);
        }


//
//		office1.listWorkers();
//		office2.listWorkers();
//
//		office1.work(4, office1.secretaries.get(0), 500);
//		office2.work(6, office2.securities.get(0), 600);
	}

    private static void doStuff(Office office) {
        office.init();
        office.listWorkers();
    }
}
