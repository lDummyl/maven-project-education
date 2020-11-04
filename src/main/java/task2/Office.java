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

    public void setSecretary(SecretaryImpl secretaryImpl) {
        this.secretary = secretaryImpl;
    }
    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат


    void invitePeople(Object human) {
        Collection<SecretaryImpl> secretaries = hr.addSecretaryCandidate(human);
        setSecretary(director.chooseSecretary(secretaries));
    }

}
