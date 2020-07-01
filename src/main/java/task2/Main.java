package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

public class Main {
	public static void main(String[] args) {
		// TODO: 7/1/20 а что если их будет 100? или 10 000? Первая задача как раз решает проблемы снабжения коллекциями объектов,
		//  нужно ее немного доработать чтобы она предоставляла сотрудников в нужном количестве и использовать здесь.
		Office office1 = new Office();
		Secretary secretary1 = new Secretary();
		Secretary secretary2 = new Secretary();
		Secretary secretary3 = new Secretary();
		Secretary secretary4 = new Secretary();
		Secretary secretary5 = new Secretary();
		Secretary secretary6 = new Secretary();
		Secretary secretary7 = new Secretary();
		Secretary secretary8 = new Secretary();
		Secretary secretary9 = new Secretary();
		Secretary secretary10 = new Secretary();
		Secretary secretary11 = new Secretary();
		Secretary secretary12 = new Secretary();
		office1.director = new Director(office1);
		office1.hr = new Hr(office1);
		office1.invitePeaople(secretary1);
		office1.invitePeaople(secretary2);
		office1.invitePeaople(secretary3);
		office1.invitePeaople(secretary4);
		office1.invitePeaople(secretary5);
		office1.invitePeaople(secretary6);
		office1.invitePeaople(secretary7);
		office1.invitePeaople(secretary8);
		office1.invitePeaople(secretary9);
		office1.invitePeaople(secretary10);
		office1.invitePeaople(secretary11);
		office1.invitePeaople(secretary12);
	}
}