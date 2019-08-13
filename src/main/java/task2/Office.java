package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {
	private Secretary secretary; // ??? Пока не знаю что он тут делает // работает конечно, у диретора конечно может быть личный секретарь, но пока всеже это будет скорее офис-менеджер.
	// тут немного не понял. с учетом нововведений, что собеседоваться могут еще и бездельники
	// и при это они тоже проходят, получается что у директора не Secretary должен быть, а Object или WantAJob?
	// понял

	private List<Accountant> accountants = new ArrayList<>();
	private SecurityOfficer security;
	private Lawyer lawyer;

	// чтож пора нанять еще людей по тому же принципу, пусть будут еще 2 бухгалтера, охранник и юрист. Эх, добавится работы ХРу ну и директору.

	private Director director = new Director(this); // 5 баллов, если не подглядывал, если подглядел все равно зачет.
														   // делаю сам. подглядывать не собираюсь, т.к. хочу иметь понимание всего что делается в задаче
	private Hr hr = new Hr();

	//претенденты идут по одному, когда их достаточно,
	// то диретор принимает решение и берет одного в штат

	void invitePeaople(ArrayList<Object> secretaries) {
		for (Object candidate : secretaries) {
			if (candidate instanceof WantAJob) {
				hr.interview((WantAJob) candidate);
			}
		}

		//boolean offerCandidates = candidates.size() > 1; // лучше пусть директор рещает а не Офис.
		//if (offerCandidates) {
        //}

        List<Object> candidates;

        candidates = hr.selectCandidates(Secretary.class);
        secretary = (Secretary) director.choseCandidate(candidates);

        candidates = hr.selectCandidates(SecurityOfficer.class);
        security = (SecurityOfficer) director.choseCandidate(candidates);

        candidates = hr.selectCandidates(Lawyer.class);
        lawyer = (Lawyer) director.choseCandidate(candidates);

        // лист побороть пока не смог. не могу сообразить универсальный метод, который сможет обработать кандидата (проверить на дубликаты) и добавить в лист (в любой, котрый укажу)
        int accountantsOnStaff = director.getAccountantsOnStaff();
        candidates = hr.selectCandidates(Accountant.class);
        for (int i = 1; i <= accountantsOnStaff; i++) {
            Accountant candidate = (Accountant) director.choseCandidate(candidates);
            if (accountants.size() > 0) {
                if (director.checkDuplicates(candidate, accountants)) {
                    i--;
                } else {
                    accountants.add(candidate);
                }
            } else {
                accountants.add(candidate);
            }
        }
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Accountant> getAccountants() {
        return accountants;
    }

	public void setAccountants(List<Accountant> accountants) {
		this.accountants = accountants;
	}

	public SecurityOfficer getSecurity() {
		return security;
	}

	public void setSecurity(SecurityOfficer security) {
		this.security = security;
	}

	public Lawyer getLawyer() {
		return lawyer;
	}

	public void setLawyer(Lawyer lawyer) {
		this.lawyer = lawyer;
	}

	// оставил закомменченым для информации
	//private void offerCandidates() {
	//    List<WantAJob> candidates = hr.getCandidates();
	//    if (candidates.size() > 1) // это называется magic number лучше завести константу или просто поле, которое будет означать что она из себя представляет
	//        director.makeDecision(candidates);
	//    System.out.println(director.getSecretary()); // лучше проверку вынести см. комментарии в Main
	//}
}
