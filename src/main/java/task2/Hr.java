package task2;


import task1.Age;
import task1.Name;
import task1.Person;

import java.util.ArrayList;
import java.util.List;

public class Hr extends Person {

    public Hr(Name name, Age age) {
        super(name, age);
    }

    public Hr(Name name) {
        super(name);
    }

    ArrayList<Secretary> candidates = new ArrayList<>();
    // TODO: 6/4/20 не нужны тебе пока геттеры и сеттеры, только мешать будут, делай пока все поля pubic просто


    // TODO: 6/4/20 статик нужно убрать и использовать созданные объекты.


    public List<Secretary> invite(Object human) {
        if (human instanceof Secretary) {
            Secretary secretary = (Secretary) human;
            if (secretary.passInterview()) {
                candidates.add(secretary);
            }
        }
        return candidates;
    }
}
