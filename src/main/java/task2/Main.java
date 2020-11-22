package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Provider;

import java.util.List;

public class Main {
	public static void main(String[] args) {

		Director director = new Director();
		Hr hr = new Hr();
		Office appleInc = new Office(director, hr);
		//Office amazonInc = null;
		Provider<Secretary> providerSecretary = Secretary::new;
		Provider<Lawyer> providerLawyer = Lawyer::new;
		List<Secretary> secretaryList = providerSecretary.provide(100);
		List<Lawyer> lawyerList = providerLawyer.provide(100);
		secretaryList.forEach(appleInc::invitePeople);
		lawyerList.forEach(appleInc::invitePeople);

		System.out.println(appleInc.secretary);
		System.out.println(appleInc.lawyer);


		if (appleInc.secretary != null){
			System.out.println("Everything's fine");
		} else {
			System.out.println("Not good at all");
		}


	}
}
