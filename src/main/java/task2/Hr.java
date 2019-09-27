package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<Secretary> listSeekersOnSecretary = new ArrayList<>();
    List<Accountant> listSeekersOnAccountant = new ArrayList<>();

    Office office;

    String name;

    public Hr(String name) {
        this.name = name;
    }


    public void considerAnyCandidate(Object candidate) {
        if (!((WantAWork)candidate).passInterview()) {
            return;
        }
        if(((WantAWork)candidate).isHired()){
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
