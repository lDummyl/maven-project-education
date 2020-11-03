package task2;

import org.junit.Test;
import task1.CandidateProvider;

import java.util.Collection;


public class OfficeTest {
	Office apple = new Office(new GeneralDirector(), new GeneralHr());
	Office google = new Office(new SecondDirector(), new SecondHr());
	CandidateProvider candidateProvider = new CandidateProvider();
	@Test
	public void invitePeaople() {


		int numberOfCandidate = 100;
		Collection<CandidateProvider.Secretary> secretaries = candidateProvider.generateCandidate(numberOfCandidate, Secretary.class);
		secretaries.forEach(apple::invitePeople);

	}
}