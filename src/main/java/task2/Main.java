package task2;
import java.util.ArrayList;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

/*Доп задания

написать тесты:

1. кейс вызвать негодование начальства
2. все ок секретарь выбран из списка
3. секретарей выдано мало ни один не выбран

* */


public class Main {
	public static void main(String[] args) {

        ArrayList<Object> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Маша"));
		secretaries.add(new Secretary("Алла"));
		secretaries.add(new Secretary("Анжелла"));
		secretaries.add(new Secretary("Зина"));
		secretaries.add(new Secretary("Марина"));
		secretaries.add(new Secretary("Лера"));

        Office office = new Office();
        secretaries.forEach(office::invitePeople);

		System.out.println(office.secretary);

	}
}
