package task2;

import java.util.List;

public class Office {

    //Secretary secretary; // ??? Пока не знаю что он тут делает // работает конечно, у диретора конечно может быть личный секретарь, но пока всеже это будет скорее офис-менеджер.
    private Director director = new Director();
    private Hr hr = new Hr();

    //претенденты идут по одному, когда их достаточно,
    // то диретор принимает решение и берет одного в штат

    void invitePeaople(Object human) {
    	//System.out.println(human);
        if(human instanceof WantAJob){
			hr.interview((WantAJob) human);
			//System.out.println(hr.getCandidates());
		}
    }

    public void offerCandidates() {
        List<WantAJob> candidates = hr.getCandidates();
        if (candidates.size() > 1) // это называется magic number лучше завести константу или просто поле, которое будет означать что она из себя представляет
            director.makeDecision(candidates);
        System.out.println(director.getSecretary()); // лучше проверку вынести см. комментарии в Main
    }
}
