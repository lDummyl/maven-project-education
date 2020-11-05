package task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.TreeSet;

public class LocalDirector implements Director{
    @Override
    public SecretaryImpl chooseSecretary(Collection<SecretaryImpl> candidates) {
        int expectedCandidates = 100;
        Random random = new Random();

        if (candidates.size() >= expectedCandidates){
            ArrayList<SecretaryImpl> secretaries = new ArrayList<>(candidates);
            return secretaries.get(random.nextInt(secretaries.size()/2));
        }
        else {
            throw new IllegalStateException("Not enough candidates");
        }
    }
    public Security chooseSecurity(Collection<Security> candidates) {
        int expectedCandidates = 100;
        Random random = new Random();

        TreeSet<Security> securities = new TreeSet<>(candidates);
        if (candidates.size() >= expectedCandidates){
            return (Security) securities.first();
        }
        else {
            throw new IllegalStateException("Not enough candidates");
        }
    }




}
