package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

public class Main {
	public static void main(String[] args) {
		Office office = new Office();
		String[] names = {"Zina", "Masha"};
		Secraetary zina = new Secraetary("Zina");
		for (String name : names) {
			System.out.println(name);
		}
		office.invitePeaople(zina);

	}
}
