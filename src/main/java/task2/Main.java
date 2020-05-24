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
	public static void main(String[] args) {

		PersonProvider personProvider = new PersonProvider();

		List<Secretary> secretaries = personProvider.getSomeSecretaries(20);
		List<Security> securities = personProvider.getSomeSecurities(20);
		List<Jurist> jurists = personProvider.getSomeJurists(20);
		List<Accountant> accountants = personProvider.getSomeAccountants(20);

		Director director = new Director(personProvider.getSomePerson());
		Hr hr = new Hr(personProvider.getSomePerson());

		Office office = new Office();
		office.setDirector(director);
		office.setHr(hr);
		office.invitePeaople(director.invite(hr.filterOfficeWorker(secretaries)));

		/*
		Я пока еще не закончил. Вроде разобрался с созданием людей разных должностей, но сейчас уперся в приведение типов.
		Я хотел сделать у Hr метод фильтрации, через который можно было бы прогонять людей любой должности и отсеивать
		часть по какому-либо критерию (был skill). Далее отфильтрованный список работников попадал в метод к директору и он
		случайно выбирал одного. Сейчас я не могу принять какого-либо человека, так как фильтр ожидает от меня OfficeWorker,
		а я ему передаю лист Secretary. То есть мне либо писать фильтр на каждый тип сотрудников у Hr (и у директора тоже,
		что мне кажется очень нелогичным), либо еще подумать над тем, как привести один тип к другому.
		 */

		// TODO: 5/21/20 ну а что директора и HR какие-то особенные? Такие же офисные сотрудники как и все прочие, зачем нам 2 разных способа создания?



    }



//	public static List<OfficeWorker> createWorker(String position, int amountOfPosition){
//		Random random = new Random();
//		switch (position){
//			case "Secretary":
//				List<OfficeWorker> secretaries = new ArrayList<>();
//				for(int i=0; i<amountOfPosition; i++){
//					secretaries.add(new Secretary(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
//							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
//				}
//				return secretaries;
//				//break;
//			case "Security":
//				List<OfficeWorker> securities = new ArrayList<>();
//				for(int i=0; i<amountOfPosition; i++){
//					securities.add(new Security(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
//							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
//				}
//				return securities;
//			//break;
//			case "Jurist":
//				List<OfficeWorker> jurists = new ArrayList<>();
//				for(int i=0; i<amountOfPosition; i++){
//					jurists.add(new Jurist(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
//							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
//				}
//				return jurists;
//			//break;
//			case "Accountant":
//				List<OfficeWorker> accountants = new ArrayList<>();
//				for(int i=0; i<amountOfPosition; i++){
//					accountants.add(new Accountant(task1.Main.getFirstN().get(random.nextInt(task1.Main.getFirstN().size())),
//							task1.Main.getLastN().get(random.nextInt(task1.Main.getLastN().size())), random.nextInt(10)));
//				}
//				return accountants;
//			//break;
//		}
//        return null;
//	}


}
