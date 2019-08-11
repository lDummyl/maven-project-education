package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;

public class Main {

	// Этот класс по большому счету не нужен вовсе(ну только ради условия), потому что то что мы пишем в нем это
	// по сути тестирование класса Офис.
	// Мы создаем исходные данные, передаем в тестируемый объект и проверяем его на предмет того именился ли он
	// соответсвующим образом, и тогда все встанет на свои места, пропадет "рука бога", которая и приглашает и
	// предлагает кандидатов, это должно быть инкапсулировано в офисе.
	public static void main(String[] args) {
		Office office = new Office();

		ArrayList<Object> labourMarket = new ArrayList<>();
		labourMarket.add(new Secretary("Oleg"));
		labourMarket.add(new Secretary("Zina"));
		labourMarket.add(new Secretary("Ivan"));
        labourMarket.add(new Secretary("Boris"));

        labourMarket.add(new Sluggard("Fedor"));
        labourMarket.add(new Sluggard("Pyotr"));
        labourMarket.add(new Sluggard("Frol"));
        labourMarket.add(new Sluggard("Segey"));
        labourMarket.add(new Sluggard("Tanya"));
        labourMarket.add(new Sluggard("Grisha"));
        labourMarket.add(new Sluggard("Alevtina"));
        labourMarket.add(new Sluggard("Kolya"));
        labourMarket.add(new Sluggard("Viktor Ivanovich"));

        labourMarket.add(new SecurityOfficer("Ignat"));
        labourMarket.add(new SecurityOfficer("Gleb"));
        labourMarket.add(new SecurityOfficer("Yaroslav"));
        labourMarket.add(new SecurityOfficer("Vitaliy"));

        labourMarket.add(new Lawyer("Janna"));
        labourMarket.add(new Lawyer("Mariya"));
        labourMarket.add(new Lawyer("Nadejda"));
        labourMarket.add(new Lawyer("Svetlana"));

        labourMarket.add(new Accountant("Evgeniy"));
        labourMarket.add(new Accountant("Anatoliy"));
        labourMarket.add(new Accountant("Anna"));
        labourMarket.add(new Accountant("Inna"));
        labourMarket.add(new Accountant("Valeriya"));

		office.invitePeaople(labourMarket);

		System.out.println(office.getSecretary()); // есть один нюанс, который пока я не знаю как лучше решить
                                                   // получается что собеседуются объекты разных классов
												   // и у Sluggard может не быть name.
												   // как лучше это реализовать, чтобы при обращении к имени из вне не получить ошибку?
												   // пока что в голову пришло только одно решение: в интерфейс добавить метод Boolean haveName(), на который можно будет ориентироваться
												   // но мне кажется что это костыль)

		// любой объект можно кастовать в класс, прежде чем обращаться с ним как с объектом этого класса, но можно делать провеки преде этим, instanceof например или не делать и полагаться на случай.

        System.out.println(office.getSecurity());
        System.out.println(office.getLawyer());
        System.out.println(office.getAccountants());
	}
}
