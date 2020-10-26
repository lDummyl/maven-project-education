package task2;

import bonus.refactor.lomb.Second;
import task1.Person;

import java.util.ArrayList;
import java.util.Collection;

public class Office {
    Secretary secretary;

    Director director;

    Hr hr;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }
    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат

    void invitePeople(Object human) {
        this.hr.addSecretaryCandidate(human);

    }
}
