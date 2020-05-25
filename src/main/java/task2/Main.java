package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import task1.Person;
import task1.PersonProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		PersonProvider personProvider = new PersonProvider();

		// TODO: 5/26/20 как думашь стоит уже убрать копипасту, или может создать бизнес центр?
		List<Secretary> secretaries1 = personProvider.getSomeSecretaries(50);
		List<Security> securities1 = personProvider.getSomeSecurities(50);
		List<Jurist> jurists1 = personProvider.getSomeJurists(50);
		List<Accountant> accountants1 = personProvider.getSomeAccountants(50);

		Director d1 = new Director(personProvider.getSomePerson());
		Hr hr1 = new Hr(personProvider.getSomePerson());
		Office office1 = new Office();
		office1.setDirector(d1);
		office1.setHr(hr1);
		office1.invitePeaople(d1.inviteSecretary(hr1.filterSecretary(secretaries1)));// TODO: 5/26/20 что это у тебя hr такой бойкий не доехав до офиса уже отбирает, не порядок
		office1.invitePeaople(d1.inviteSecurity(hr1.filterSecurity(securities1)));
		office1.invitePeaople(d1.inviteJurist(hr1.filterJurist(jurists1)));
		office1.invitePeaople(3, d1.inviteAccountant(hr1.filterAccountant(accountants1)),
				d1.inviteAccountant(hr1.filterAccountant(accountants1)),
				d1.inviteAccountant(hr1.filterAccountant(accountants1)));



		office1.listWorkers();



		List<Secretary> secretaries2 = personProvider.getSomeSecretaries(50);
		List<Security> securities2 = personProvider.getSomeSecurities(50);
		List<Jurist> jurists2 = personProvider.getSomeJurists(50);
		List<Accountant> accountants2 = personProvider.getSomeAccountants(50);

		// TODO: 5/26/20 какие-то они у тебя бездушные, давай один директор будет добрый а другой капризный, только не на совах а на деле.
		Director d2 = new Director(personProvider.getSomePerson());
		Hr hr2 = new Hr(personProvider.getSomePerson());
		Office office2 = new Office();
		office2.setDirector(d2);
		office2.setHr(hr2);
		office2.invitePeaople(d2.inviteSecretary(hr2.filterSecretary(secretaries2)));
		office2.invitePeaople(d2.inviteSecurity(hr2.filterSecurity(securities2)));
		office2.invitePeaople(d2.inviteJurist(hr2.filterJurist(jurists2)));
		office2.invitePeaople(2, d2.inviteAccountant(hr2.filterAccountant(accountants2)),
				d2.inviteAccountant(hr2.filterAccountant(accountants2)));

		/*
		Готово. Метод, который добавляет несколько сотрудников тоже простыня. И Hr фильтрует не по критериям,
		а просто берет первые 20 человек из 50 сгенерированных людей и дает их директору.
		 */
		// TODO: 5/26/20 ну так не пойдет, все должно быть как в жизни, интервью с каждым, а директор принимает решение из оставшихся вариантов.

		office2.listWorkers();


    }
}
