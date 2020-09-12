package task2.util;

import task1.util.Generator;
import task2.model.SecretaryEmployee;
import task2.model.Secretary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CandidateGenerator implements Generator<Secretary> {

    @Override
    public List<Secretary> generate() {
        Random r = new Random();
        List<Secretary> candidates = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            candidates.add(new SecretaryEmployee(r.nextInt(1000)));
        }
        return candidates;
    }
}
