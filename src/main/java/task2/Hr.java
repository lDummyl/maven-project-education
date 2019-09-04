package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    List<WantAWork> listSeekersOnSecretary = new ArrayList<>();
    List<WantAWork> listSeekersOnAccountant = new ArrayList<>();

    String name;

    public Hr(String name) {
        this.name = name;
    }

    public List<WantAWork> considerCandidateSecretaries(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел

            if(candidate.passInterview() && candidate instanceof Secretary) {
                listSeekersOnSecretary.add(candidate);
                return listSeekersOnSecretary;
            }
            else{
            listJobSeekers.add(candidate);                           // остальные
            return listSeekersOnSecretary;
            }

    }

    public List<WantAWork> considerCandidateAccountants(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел

            if(candidate.passInterview() && candidate instanceof Accountant){
                listSeekersOnAccountant.add(candidate);
            return listSeekersOnAccountant;
            }
            else{
                listJobSeekers.add(candidate);                           // остальные
                return listSeekersOnAccountant;
            }
    }

}
