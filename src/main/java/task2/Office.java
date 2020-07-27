package task2;

public class Office {

	Secretary secretary;

	Director director = new Director();

	Hr hr;

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeople(Object human){
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
