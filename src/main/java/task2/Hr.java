package task2;

import java.util.ArrayList;
import java.util.List;

class Hr {
    List<WantAWork> listJobSeekers = new ArrayList<>();
    String name;

    public Hr(String name) {
        this.name = name;
    }

    public List<WantAWork> considerCandidate(WantAWork candidate) {  //метод в котором Hr рассматривает кандидатов, которые приходят из офиса (invitePeople) и возвращает список тех кто прошел
        if (candidate.passInterview()) {               //если кандидат прошел интерьвью passInterview() возвращает true
            listJobSeekers.add(candidate);             //и в список listJobSeekers добавляется кандидат
        }
        return listJobSeekers;                         //возвращаем список
    }

}
