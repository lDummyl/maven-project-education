package task2;

import java.util.ArrayList;
import java.util.List;

public class Hr {
    private List<WantAJob> candidates = new ArrayList<>();

    public void interview(WantAJob candidate) {
        if (candidate.passInterview()) {
            candidates.add(candidate);
        }
    }

    public List<Object> selectCandidates(Class<? extends Object> clazz) {
        List<Object> pertain = new ArrayList<>();
        for (WantAJob candidate : candidates) {
            if (clazz.isInstance(candidate))
                pertain.add(candidate);
        }
        return pertain;
    }

    public List<WantAJob> getCandidates() {
        return candidates;
    }
}
