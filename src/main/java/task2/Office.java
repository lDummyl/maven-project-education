package task2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

public class Office {
    Secretary secretary;
    Director director;
    Hr hr;
    Manager manager;
    Lawyer lawyer;
    Guard guard;



    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    // TODO: 11/16/20 убери этот нойз просто присвоение по месту делай

    public void setSecretary(SecretaryImpl secretaryImpl) {
        this.secretary = secretaryImpl;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }

    public void setGuard(Guard guard) {
        this.guard = guard;
    }

    public<T extends Worker> void setWorker(Worker candidate){
        if (candidate.getClass().equals(Manager.class)){
            setManager((Manager) candidate);
        } else if (candidate.getClass().equals(Lawyer.class)){
            setLawyer((Lawyer) candidate);
        }
        else if (candidate.getClass().equals(Guard.class)){
            setGuard((Guard) candidate);
        }
    }



    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат


    void invitePeople(Object human) {
        hr.addCandidate(human);
       // director.chooseWorker(hr.getCandidates());
    }

    // TODO: 11/16/20 для всех одна дверь, нет двери для охраниников и для секретарей отдельно

}
