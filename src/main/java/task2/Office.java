package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {

	Director director;

	Hr hr;


	private static final List<Secretary> secretaries = new ArrayList<>();


	public Office(Director director, Hr hr) {
		this.director = director;
		this.hr = hr;
	}

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
		// TODO: 7/27/20 чтобы не было каши разделяй на смысловые группы, все что можно отделить должно быть отдельным методом. Проверка ком состав
		//  провека на рядовой состав и так далее. И помни офис это 4 чтены  и дверь, он содержит минимум логики, всю работу делают люди.
		if (hr.checkNumberOfSecretaries(secretaries)) {
			if (human instanceof Secretary) {
				secretaries.add((Secretary) human);
			}
		} else {
			director.chooseSecretary(secretaries);
		}
	}
}
