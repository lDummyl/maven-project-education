package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

public class Main {
	public static void main(String[] args) {


        Secretary secretary0 = new Secretary();
        Secretary secretary1 = new Secretary();
        Secretary secretary2 = new Secretary();
        Secretary secretary3 = new Secretary();
        Secretary secretary4 = new Secretary();
        Secretary secretary5 = new Secretary();
        Secretary secretary6 = new Secretary();
        Secretary secretary7 = new Secretary();
        Secretary secretary8 = new Secretary();
        Secretary secretary9 = new Secretary();

        Office office = new Office();
        office.invitePeaople(secretary0);

    }
}
