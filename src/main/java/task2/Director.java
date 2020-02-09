package task2;

import java.util.List;
import java.util.Random;

public class Director extends CompanyEmployee {

    private int enoughCandidatesToDecide;

    public Director(String name, int qty) {
        super(name);
        enoughCandidatesToDecide = qty;
    }

    public Director() {
        this("Default name", 3);
    }

    @Override
    public boolean passInterview() {
        return false;
    }

    public Secretary considerCandidates(List<Secretary> successCandidates) {
        if (successCandidates.size() >= enoughCandidatesToDecide) {
            Random random = new Random();
            int index = random.nextInt(successCandidates.size());
            Secretary secretary = successCandidates.get(index);
            return secretary;
        } else {
            System.out.println("Cant choose, not enough!");
            return null;
        }
    }

    public AllCandidate considerCandidates2(List<AllCandidate> successCandidates) {
        Random random = new Random();
        AllCandidate allCandidate = successCandidates.get(random.nextInt(successCandidates.size()));
        return allCandidate;
    }

    public Loader considerCandidateLoader(List<Loader> successCandidates) {
        Random random = new Random();
        Loader loader = successCandidates.get(random.nextInt(successCandidates.size()));
        return loader;
    }
}
