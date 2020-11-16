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

    // TODO: 11/16/20 убери этот нойз просто присвоение по месту делай
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

    // TODO: 11/16/20 для всех одна дверь, нет двери для охраниников и для секретарей отдельно

}
