package task2;

import java.util.ArrayList;
import java.util.List;

public class Office {
    //Secretary secretary; // ??? Пока не знаю что он тут делает // работает конечно, у диретора конечно может быть личный секретарь, но пока всеже это будет скорее офис-менеджер.
                           // тут немного не понял. с учетом нововведений, что собеседоваться могут еще и бездельники
                           // и при это они тоже проходят, получается что у директора не Secretary должен быть, а Object или WantAJob?
    private Director director = new Director();
    private Hr hr = new Hr();

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeaople(ArrayList<Object> secretaries) {
        for (Object candidate : secretaries) {
            if(candidate instanceof WantAJob) {
                hr.interview((WantAJob) candidate);
            }
        }

        List<WantAJob> candidates = hr.getCandidates();
        boolean offerCandidates = candidates.size() > 1;
        if (offerCandidates)
            director.makeDecision(candidates);
    }

    // убрал этот метод, но пока до конца не уверен что окончательно
    //private void offerCandidates() {
    //    List<WantAJob> candidates = hr.getCandidates();
    //    if (candidates.size() > 1) // это называется magic number лучше завести константу или просто поле, которое будет означать что она из себя представляет
    //        director.makeDecision(candidates);
    //    System.out.println(director.getSecretary()); // лучше проверку вынести см. комментарии в Main
    //}

    public WantAJob getDirectorSecretary() {
        return director.getSecretary();
    }
}
