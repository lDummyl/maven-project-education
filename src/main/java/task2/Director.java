package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;

    final int enoughCandidatesToDecide = 3;

    Random random = new Random();

    public Director(Office myOffice) {
        this.myOffice = myOffice;
    }

    public WantAWork chooseOneCandidate(List<? extends WantAWork> currentCandidates) {
        WantAWork candidate = null;
        if(currentCandidates.size() == enoughCandidatesToDecide){
            candidate = currentCandidates.get(random.nextInt(currentCandidates.size()));
        }
        return candidate;
    }

    public void chooseSecretary(List<Secretary> currentCandidates) {
        if(myOffice.secretary == null) {
            Secretary secretary = (Secretary) chooseOneCandidate(currentCandidates);
            if(secretary != null) {
                myOffice.setSecretary(secretary);
                secretary.hired = true;
            }
        }
    }

    public void chooseAccountant(List<Accountant> currentCandidates) {
        if(myOffice.accountant == null) {
            Accountant accountant = (Accountant) chooseOneCandidate(currentCandidates);
            if(accountant != null) {
                myOffice.setAccountant(accountant);
                accountant.hired = true;
            }
        }
    }
}
