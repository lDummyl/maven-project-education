package task2;

import java.util.List;
import java.util.Random;

public class Director {

    private final Office office;
    private Random random = new Random();

    private final int enoughCandidatesToDecide = 3; // теперь это не magic number, и не стоит выбирать из одного кандидата
    private final int accountantsOnStaff = 2;

    public Director(Office office) {
        this.office = office;
    }

    public void makeDecision() {
        Hr hr = office.getHr();

        Secretary secretary = choseCandidate(hr.getSecretaries());
        if (secretary != null) {
            secretary.setOfficeImHiredIn(office);
            office.setSecretary(secretary);
        }

        SecurityOfficer security = choseCandidate(hr.getSecurities());
        if (security != null) {
            security.setOfficeImHiredIn(office);
            office.setSecurity(security);
        }

        Lawyer lawyer = choseCandidate(hr.getLawyers());
        if (lawyer != null) {
            lawyer.setOfficeImHiredIn(office);
            office.setLawyer(lawyer);
        }

        List<Accountant> accountants = office.getAccountants();
        List<Accountant> candidates = hr.getAccountants();
        int accountantsWorks = accountants.size();
        for ( ;accountantsWorks < accountantsOnStaff; accountantsWorks++) {
            Accountant accountant = choseCandidate(candidates);
            if (accountant != null) {
                accountant.setOfficeImHiredIn(office);
                accountants.add(accountant);
                candidates.remove(accountant);
            }
        }
    }

    private <T extends WantAJob> T choseCandidate(List<T> candidates) {
        T newEmployee = null;
        if (candidates.size() >= enoughCandidatesToDecide) {
            int lastIndex = candidates.size() - 1;
            while (newEmployee == null) {
                T candidate = candidates.get(random.nextInt(lastIndex));
                if (candidate.makeDecision()) { // тут есть нюанс, когда кандидат может отклонить офер, а потом в рандоме опять выпадет он и у себя в методе примет офер
                                                // пока не знаю как это решить
                    if (candidate.getOfficeImHiredIn() == null) {
                        newEmployee = candidate;
                    } else {
                        System.out.println("You need to fire yourself first, when come back to hire");
                    }
                }
            }
        }
        return newEmployee;
    }
}
