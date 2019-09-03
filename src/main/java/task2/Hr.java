package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    List<WantAWork> listSeekersSecretary = new ArrayList<>();
    List<WantAWork> listSeekersAccountant = new ArrayList<>();

    String name;

    public Hr(String name) {
        this.name = name;
    }

    public List<WantAWork> considerCandidate(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел


            if(candidate.passInterview() && candidate instanceof Secretary) {
                listSeekersSecretary.add(candidate);
             //   System.out.println("listSeekersSecretary - " + listSeekersSecretary);
                return listSeekersSecretary;
            }
            if(candidate.passInterview() && candidate instanceof Accountant){
                listSeekersAccountant.add(candidate);
                return listSeekersAccountant;
            }

            listJobSeekers.add(candidate);                           // остальные
            return listJobSeekers;

    }

}
