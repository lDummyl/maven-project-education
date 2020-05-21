package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		Random random = new Random();
		// TODO: 5/20/20 не очень выразительные имена, помему не использовать функционал первой задчи? Скажем расширить и адаптировать затем просто ипортировать тамошние классы без КП.
		Director director1 = new Director(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
				task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())));
		Director director2 = new Director(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
				task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())));
		Hr hr1 = new Hr(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
				task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())));
		Hr hr2 = new Hr(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
				task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())));

		// TODO: 5/20/20 кроме того мы же делали это чтобы не приходилось дальше ваять такие небоскребы, что если в задании было бы скажем 100 кандидатов, вполне жизненная ситуация.
		List<OfficeWorker> candidatesSecretary1 = createWorker("Secretary", 50);
		List<OfficeWorker> candidatesSecretary2 = createWorker("Secretary", 50);

		Office office1 = new Office(director1, hr1, candidatesSecretary1);
		Office office2 = new Office(director2, hr2, candidatesSecretary2);
		office1.listWorkers();
		office2.listWorkers();

    }


//    public static List<OfficeWorker> createSecretary(int amountOfSecretary){
//		Random random = new Random();
//		List<OfficeWorker> secretaries = new ArrayList<>();
//		for(int i=0; i<amountOfSecretary; i++){
//			secretaries.add(new Secretary(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
//					task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
//		}
//		return secretaries;
//	}

	public static List<OfficeWorker> createWorker(String position, int amountOfPosition){
		Random random = new Random();
		switch (position){
			case "Secretary":
				List<OfficeWorker> secretaries = new ArrayList<>();
				for(int i=0; i<amountOfPosition; i++){
					secretaries.add(new Secretary(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
				}
				return secretaries;
				//break;
			case "Security":
				List<OfficeWorker> securities = new ArrayList<>();
				for(int i=0; i<amountOfPosition; i++){
					securities.add(new Security(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
				}
				return securities;
			//break;
			case "Jurist":
				List<OfficeWorker> jurists = new ArrayList<>();
				for(int i=0; i<amountOfPosition; i++){
					jurists.add(new Jurist(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
				}
				return jurists;
			//break;
			case "Accountant":
				List<OfficeWorker> accountants = new ArrayList<>();
				for(int i=0; i<amountOfPosition; i++){
					accountants.add(new Accountant(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
				}
				return accountants;
			//break;
		}
        return null;
	}


}
