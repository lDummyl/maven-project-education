package task2;

//Сделать 10 секретарей 1 hr и директора котторый
// выбирает рандомно секретаря в штат, которого ему пердлагает HR,
// все это происходит в офисе

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static void main(String[] args) {

		// TODO: 5/20/20 не очень выразительные имена, помему не использовать функционал первой задчи? Скажем расширить и адаптировать затем просто ипортировать тамошние классы без КП.
		Director director1 = new Director("Director1", 10);
		Director director2 = new Director("Director2", 10);
		Hr hr1 = new Hr("Hr1");
		Hr hr2 = new Hr("Hr2");

		// TODO: 5/20/20 кроме того мы же делали это чтобы не приходилось дальше ваять такие небоскребы, что если в задании было бы скажем 100 кандидатов, вполне жизненная ситуация.
		List<OfficeWorker> candidatesSecretary1= new ArrayList<>();
		Secretary secretary10 = new Secretary("Secretary10", 0);
		Secretary secretary11 = new Secretary("Secretary11", 1);
		Secretary secretary12 = new Secretary("Secretary12", 2);
		Secretary secretary13 = new Secretary("Secretary13", 3);
		Secretary secretary14 = new Secretary("Secretary14", 4);
		Secretary secretary15 = new Secretary("Secretary15", 5);
		Secretary secretary16 = new Secretary("Secretary16", 6);
		Secretary secretary17 = new Secretary("Secretary17", 7);
		Secretary secretary18 = new Secretary("Secretary18", 8);
		Secretary secretary19 = new Secretary("Secretary19", 9);
		candidatesSecretary1.add(secretary10);
		candidatesSecretary1.add(secretary11);
		candidatesSecretary1.add(secretary12);
		candidatesSecretary1.add(secretary13);
		candidatesSecretary1.add(secretary14);
		candidatesSecretary1.add(secretary15);
		candidatesSecretary1.add(secretary16);
		candidatesSecretary1.add(secretary17);
		candidatesSecretary1.add(secretary18);
		candidatesSecretary1.add(secretary19);

		List<OfficeWorker> candidatesSecretary2 = new ArrayList<>();
		Secretary secretary20 = new Secretary("Secretary20", 9);
		Secretary secretary21 = new Secretary("Secretary21", 8);
		Secretary secretary22 = new Secretary("Secretary22", 7);
		Secretary secretary23 = new Secretary("Secretary23", 6);
		Secretary secretary24 = new Secretary("Secretary24", 5);
		Secretary secretary25 = new Secretary("Secretary25", 4);
		Secretary secretary26 = new Secretary("Secretary26", 3);
		Secretary secretary27 = new Secretary("Secretary27", 2);
		Secretary secretary28 = new Secretary("Secretary28", 1);
		Secretary secretary29 = new Secretary("Secretary29", 0);
		candidatesSecretary2.add(secretary20);
		candidatesSecretary2.add(secretary21);
		candidatesSecretary2.add(secretary22);
		candidatesSecretary2.add(secretary23);
		candidatesSecretary2.add(secretary24);
		candidatesSecretary2.add(secretary25);
		candidatesSecretary2.add(secretary26);
		candidatesSecretary2.add(secretary27);
		candidatesSecretary2.add(secretary28);
		candidatesSecretary2.add(secretary29);

		Office office1 = new Office(director1, hr1, candidatesSecretary1);
		Office office2 = new Office(director2, hr2, candidatesSecretary2);
		office1.listWorkers();
		office2.listWorkers();






    }


}
