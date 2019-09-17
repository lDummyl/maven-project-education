package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    // TODO: 9/4/19 раз мы уже отсортировали их то почему бы не определить как класс
    List<Secretary> listSeekersOnSecretary = new ArrayList<>();
    List<Accountant> listSeekersOnAccountant = new ArrayList<>();

    Office office;
    Secretary secretary;

    String name;

    public Hr(String name) {
        this.name = name;
    }


    public void considerAnyCandidate(Object candidate, boolean choiceSecretaryMade, boolean choiceAccountantMade) {
        if (!((WantAWork)candidate).passInterview()) {
            return;
        }
        if(((WantAWork)candidate).isHired()){
            return;
        }

        if (choiceSecretaryMade && choiceAccountantMade){
            System.out.println("(Hr) considerAnyCandidate - return !!!");
            return;
        }

        if(candidate instanceof Secretary){
            System.out.println("listSeekersOnSecretary (Hr) - " + listSeekersOnSecretary);
            listSeekersOnSecretary.add((Secretary) candidate);
            System.out.println("listSeekersOnSecretary (Hr) after - " + listSeekersOnSecretary);
        }
        if(candidate instanceof Accountant){
            System.out.println("listSeekersOnAccountant (Hr) - " + listSeekersOnAccountant);
            listSeekersOnAccountant.add((Accountant) candidate);
            System.out.println("listSeekersOnAccountant (Hr) after - " + listSeekersOnAccountant);
        }
    }

}
