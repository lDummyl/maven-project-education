package task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class Office {
    Secretary secretary;

    Director director;

    Hr hr;

    ChiefGuard chiefGuard;

    ArrayList<Guard> guards;

    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void setChiefGuard(ChiefGuard chiefGuard) {
        this.chiefGuard = chiefGuard;
    }

    public void setSecretary(SecretaryImpl secretaryImpl) {
        this.secretary = secretaryImpl;
    }

    public void setGuards(Guard guard) {
        this.guards.add(guard);
    }
    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат


    void invitePeople(Object human) {
        Collection<SecretaryImpl> secretaries = hr.addSecretaryCandidate(human);
        setSecretary(director.chooseSecretary(secretaries));
    }

    void inviteGuardian(Object human){
        Collection<Guard> guards = hr.addGuardCandidate(human);
        setGuards(this.chiefGuard.chooseGuard(guards));
    }

}
