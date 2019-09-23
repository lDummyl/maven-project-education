package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Director {

    final Office myOffice;

    boolean choiceSecretaryMade=false;
    boolean choiceAccountantMade=false;

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
    // TODO: 9/17/19 товоя задача использовать этот метод вместо осальных, понять чего не хватает для того чтобы все заработало. Ну и убрать все лишнее.

    public void chooseSecretary(List<Secretary> currentCandidates) {
        if(!choiceSecretaryMade) {
            WantAWork wantAWork = chooseOneCandidate(currentCandidates);

            if(wantAWork != null) {
                choiceSecretaryMade = true;
                ((Secretary) wantAWork).hired = true;
            }
            myOffice.setSecretary((Secretary) wantAWork);
        }
    }

    public void chooseAccountant(List<Accountant> currentCandidates) {
        if(!choiceAccountantMade) {
            WantAWork wantAWork = chooseOneCandidate(currentCandidates);

            if(wantAWork != null) {
                choiceAccountantMade = true;
                ((Accountant) wantAWork).hired = true;
            }
            myOffice.setAccountant((Accountant) wantAWork);
        }
    }
}
