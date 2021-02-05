package task2.workers;

import task2.Director;
import task2.Secretary;


import java.util.Collection;
import java.util.TreeSet;

public class GeneralDirector extends LocalDirector implements Director {
    Secretary assistant;

    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {
        int expectedCandidates = 100;
        if (candidates.size() >= expectedCandidates) {
            TreeSet<SecretaryImpl> secretaries = new TreeSet<>(candidates);
            return secretaries.first();
        } else {
            return null;
        }
    }

    public void setAssistant(Secretary secretary) {
        this.assistant = secretary;
    }


}
