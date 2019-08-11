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

		ArrayList<Object> secretaries = new ArrayList<>();
		secretaries.add(new Secretary("Oleg"));
		secretaries.add(new Secretary("Zina"));
		secretaries.add(new Secretary("Ivan"));
        secretaries.add(new Secretary("Boris"));
        secretaries.add(new Sluggard("Fedor"));
        secretaries.add(new Sluggard("Pyotr"));
        secretaries.add(new Sluggard("Frol"));
        secretaries.add(new Sluggard("Segey"));
        secretaries.add(new Sluggard("Tanya"));
        secretaries.add(new Sluggard("Grisha"));
        secretaries.add(new Sluggard("Alevtina"));
        secretaries.add(new Sluggard("Kolya"));
        secretaries.add(new Sluggard("Viktor Ivanovich"));

		office.invitePeaople(secretaries);

		System.out.println(office.getDirectorSecretary()); // есть один нюанс, который пока я не знаю как лучше решить
														   // получается что собеседуются объекты разных классов
														   // и у Sluggard может не быть name.
														   // как лучше это реализовать, чтобы при обращении к имени из вне не получить ошибку?
														   // пока что в голову пришло только одно решение: в интерфейс добавить метод Boolean haveName(), на который можно будет ориентироваться
														   // но мне кажется что это костыль)
	}
}
