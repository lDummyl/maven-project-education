package task2;

import java.util.Random;

public class AllCandidate extends CompanyEmployee {

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                '}';
    }

    public AllCandidate(String name) {
        super(name);
    }

    @Override
    public boolean passInterview() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
