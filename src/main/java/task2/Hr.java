package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    // TODO: 9/4/19 раз мы уже отсортировали их то почему бы не определить как класс
    List<Secretary> listSeekersOnSecretary = new ArrayList<>();
    List<Accountant> listSeekersOnAccountant = new ArrayList<>();

    Office office;
//    Secretary secretary;

    String name;

    public Hr(String name) {
        this.name = name;
    }


    public void considerAnyCandidate(Object candidate, /*так ли уж нужны эти параметры для HR? -> */ boolean choiceSecretaryMade, boolean choiceAccountantMade) {
        if (!((WantAWork)candidate).passInterview()) {
            return;
        }
        if(((WantAWork)candidate).isHired()){
            return;
        }

        if (choiceSecretaryMade && choiceAccountantMade){
            return;
        }

        if(candidate instanceof Secretary){
            listSeekersOnSecretary.add((Secretary) candidate);
        }
        if(candidate instanceof Accountant){
            listSeekersOnAccountant.add((Accountant) candidate);
        }
    }

}
