package task2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;


public class OfficeTest {


	Random random = new Random();


	@Test
	public void invitePeaople() {
		ArrayList<Object> labourMarket = new ArrayList<>();
		labourMarket.add(new Secretary("Oleg"));
		labourMarket.add(new Secretary("Zina"));
		labourMarket.add(new Secretary("Ivan"));
		labourMarket.add(new Secretary("Boris"));
		labourMarket.add(new Secretary("Igor"));

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

		ArrayList<Office> offices = new ArrayList<>();
		offices.add(new Office());
        offices.add(new Office());
        offices.add(new Office());


		// TODO: 8/17/19 тесты лучше иметь на каждый кейс свой и вообще это не очень хорошо когда повденеие рандмное, тесты будут то падать то нет.
		// но раз мы приняли такое решение, то нужно создать большой рынок труда, чтобы вероятность прохождения теста, что всё всех устроят была близка к 100%,
		// стримы в помощь, только сам сделай всего побольше

		List<String> womenNames = Arrays.asList("Anna", "Inna");

		List<Secretary> aLotOfSecretaries = Stream.generate(() ->
				new Secretary(womenNames.get(random.nextInt(womenNames.size()-1))))
				.limit(10000) // почти уже биг дата!
				.collect(Collectors.toList());

		List<Accountant> aLotOfAccountans = Stream.generate(() ->
				new Accountant(womenNames.get(random.nextInt(womenNames.size()-1))))
				.limit(1000).collect(Collectors.toList());

		labourMarket.addAll(aLotOfAccountans);
		labourMarket.addAll(aLotOfSecretaries);


		for (Office office : offices) {
			office.invitePeaople(labourMarket);
		}
		// TODO: 8/17/19 ну и разделить это все конечно надо, более того желательно написать тесты на каждый класс, отдельно повление HR и тд.
		for (Office office : offices) {
            assertTrue(labourMarket.contains(office.getSecretary()));
            assertTrue(labourMarket.contains(office.getSecurity()));
            assertTrue(labourMarket.contains(office.getLawyer()));
            for (Accountant accountant : office.getAccountants())
                assertTrue(labourMarket.contains(accountant));
        }
	}
}