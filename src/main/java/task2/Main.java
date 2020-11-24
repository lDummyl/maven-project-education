package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе


public class Main {
	public static void main(String[] args) {

		ProviderEmployee providerEmployee = new ProviderEmployee(100);

		Director director = new Director(10);
		Hr hr = new Hr();
		Office appleInc = new Office(director, hr);

		providerEmployee.provide().forEach((k, v) -> v.forEach(appleInc::invitePeople));

		System.out.println(appleInc.secretary);
		System.out.println(appleInc.lawyer);
		System.out.println(appleInc.security);
		System.out.println(appleInc.firstAccountant);
		System.out.println(appleInc.secondAccountant);

	}

}
