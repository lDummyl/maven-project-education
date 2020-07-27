package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {

	private final List<Secretary> secretaries = new ArrayList<>();
	private static final int NUMBER_OF_SECRETARIES = 10;

	Secretary secretary;

	Director director;

	Hr hr;

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
		// TODO: 7/27/20 чтобы не было каши разделяй на смысловые группы, все что можно отделить должно быть отдельным методом. Проверка ком состав
		//  провека на рядовой состав и так далее. И помни офис это 4 чтены  и дверь, он содержит минимум логики, всю работу делают люди.
		if (human != null) {
			if (human instanceof Director) {
				setDirector((Director) human);
			} else if (human instanceof Hr) {
				setHr((Hr) human);
			} else if (human instanceof Secretary) {
				setSecretary((Secretary) human);
			}
		}
		if (director != null && hr != null && secretaries.size() == 10) {
			choose();
		}
	}

	private void choose() {
		int offer = hr.getRandomSecretary(NUMBER_OF_SECRETARIES);
		int choice = director.chooseSecretary(NUMBER_OF_SECRETARIES);
		if (offer == choice) {
			secretary = secretaries.get(choice);
		} else {
			choose();
		}
	}

	private void setSecretary(Secretary human) {
		if (secretaries.size() < NUMBER_OF_SECRETARIES) {
			secretaries.add(human);
		}
	}

	private void setHr(Hr human) {
		if (hr == null) {
			hr = human;
		}
	}

	private void setDirector(Director human) {
		if (director == null) {
			director = human;
		}
	}


}
