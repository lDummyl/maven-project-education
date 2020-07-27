package task2;

public class Office {

	Secretary secretary;

	Director director = new Director();

	Hr hr;

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
		// TODO: 7/27/20 чтобы не было каши разделяй на смысловые группы, все что можно отделить должно быть отдельным методом. Проверка ком состав
		//  провека на рядовой состав и так далее. И помни офис это 4 чтены  и дверь, он содержит минимум логики, всю работу делают люди.
		if (human != null) {
			if (human instanceof Director) {
				director = (Director) human;
			} else if (human instanceof Hr) {
				hr = (Hr) human;
			} else if (human instanceof Secretary) {
				if (hr.getCountOfSecretaries() < 10) {
					hr.setSecretaries(secretary);
				} else {
					if (director != null && hr != null) {
						director.getRandomSecretary(10);
					}
				}
			}
		}
	}
}
