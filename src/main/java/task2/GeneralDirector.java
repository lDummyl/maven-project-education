package task2;

import java.util.Collection;
import java.util.TreeSet;

public class GeneralDirector implements Director{
    Secretary assistant;

    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {
        int expectedCandidates = 100;
        if (candidates.size() >= expectedCandidates){
            TreeSet<SecretaryImpl> secretaries = new TreeSet<>(candidates);
            return secretaries.first();
        }
        return null;
    }

    public void setAssistant(Secretary secretary){
        this.assistant = secretary;
    }




}
