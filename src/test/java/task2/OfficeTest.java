package task2;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class OfficeTest {

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

        for (Office office : offices) {
            office.invitePeaople(labourMarket);
        }

        for (Office office : offices) {
            assertTrue(labourMarket.contains(office.getSecretary()));
            assertTrue(labourMarket.contains(office.getSecurity()));
            assertTrue(labourMarket.contains(office.getLawyer()));
            for (Accountant accountant : office.getAccountants())
                assertTrue(labourMarket.contains(accountant));
        }
	}
}
