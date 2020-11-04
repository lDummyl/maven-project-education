package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class GeneralDirector implements Director{

    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {
        int expectedCandidates = 100;
        if (candidates.size() >= expectedCandidates){
            TreeSet<SecretaryImpl> secretaries = new TreeSet<>(candidates);
            return secretaries.first();
        }
        return null;
    }
}
