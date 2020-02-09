package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Loader extends CompanyEmployee {

    @Override
    public String toString() {
        return "CandidateLoader{" +
                "name='" + name + '\'' +
                '}';
    }


    public Loader(String name) {
        super(name);
    }

    @Override
    public boolean passInterview() {
        Random random = new Random();
        return random.nextBoolean();
    }
}
