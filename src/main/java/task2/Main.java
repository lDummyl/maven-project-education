package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import javax.crypto.SecretKey;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Office office = new Office();

		Secretary secretary = new Secretary("Alla");

		office.invitePeaople(secretary);


        System.out.println("Hey");
		System.out.println("Hokus - pokus!");
	}
}
