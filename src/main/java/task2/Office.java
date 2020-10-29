package task2;

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

    void invitePeople(Object human ) {
        Collection<Secretary> secretaries = hr.addSecretaryCandidate(human);
        secretary = director.chooseSecretary(secretaries);
    }

}
