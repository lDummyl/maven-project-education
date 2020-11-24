package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Provider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

		Director director = new Director(10);
		Hr hr = new Hr();
		Office appleInc = new Office(director, hr);
		//Office amazonInc = null;

		provideEmployee().forEach((k,v) -> v.forEach(appleInc::invitePeople));

		System.out.println(appleInc.secretary);
		System.out.println(appleInc.lawyer);
		System.out.println(appleInc.security);
		System.out.println(appleInc.firstAccountant);
		System.out.println(appleInc.secondAccountant);

		if (appleInc.secretary != null){
			System.out.println("Everything's fine");
		} else {
			System.out.println("Not good at all");
		}
	}

	private static Map<Class<?>, List<? extends Employee>> provideEmployee() {
		Map<Class<?>, List<? extends Employee>> result = new HashMap<>();
//
//		Provider<Secretary> secretaryProvider = Secretary::new;
//		Provider<Lawyer> lawyerProvider = Lawyer::new;
//		Provider<Security> securityProvider = Security::new;
//		Provider<Accountant> accountantProvider = Accountant::new;

//		result.put(Secretary.class, secretaryProvider.provide(100));
//		result.put(Lawyer.class, lawyerProvider.provide(100));
//		result.put(Security.class, securityProvider.provide(100));
//		result.put(Accountant.class, accountantProvider.provide(100));

		return result;
	}
}
