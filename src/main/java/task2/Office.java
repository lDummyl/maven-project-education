package task2;

import java.util.Collection;

public class Office {
    SecretaryImpl secretaryImpl;

    Director director;

    Hr hr;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void setSecretary(SecretaryImpl secretaryImpl) {
        this.secretaryImpl = secretaryImpl;
    }
    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат

    /**

     Ass!!!

     */
    void invitePeople(Object human) {
        Collection<SecretaryImpl> secretaries = hr.addSecretaryCandidate(human);
        secretaryImpl = director.chooseSecretary(secretaries);
    }

}
