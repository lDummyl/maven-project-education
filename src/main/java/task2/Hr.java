package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    // TODO: 9/4/19 раз мы уже отсортировали их то почему бы не определить как класс
    List<Secretary> listSeekersOnSecretary = new ArrayList<>();
    List<Accountant> listSeekersOnAccountant = new ArrayList<>();

    String name;

    public Hr(String name) {
        this.name = name;
    }

    public List<Secretary> considerCandidateSecretaries(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел

            if(candidate.passInterview() && candidate instanceof Secretary && !((Secretary) candidate).hired) {   //
                listSeekersOnSecretary.add((Secretary) candidate);
                return listSeekersOnSecretary;
            }
            else{
            listJobSeekers.add(candidate);                           // остальные
            return listSeekersOnSecretary;
            }
    }

    public List<Accountant> considerCandidateAccountants(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел

            if(candidate.passInterview() && candidate instanceof Accountant && !((Accountant) candidate).hired){    //
                listSeekersOnAccountant.add((Accountant)candidate);
            return listSeekersOnAccountant;
            }
            else{
                listJobSeekers.add(candidate);                           // остальные
                return listSeekersOnAccountant;
            }
    }

}
