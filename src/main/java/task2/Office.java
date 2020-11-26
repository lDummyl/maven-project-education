package task2;

import lombok.var;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
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

    public <T> void setWorker(T worker) {
        if (worker instanceof Guard) {
            setGuard((Guard) worker);
        } else if (worker instanceof Secretary) {
            setSecretary((SecretaryImpl) worker);
        } else if (worker instanceof Lawyer) {
            setLawyer((Lawyer) worker);
        } else if (worker instanceof Manager) {
            setManager((Manager) worker);
        }
    }

    // FIXME: 24.11.2020 Не работает
    void invitePeople(Object human) {
        if (!(human instanceof Worker)) {
            throw new IllegalStateException("It's not worker");
        } else {
            this.hr.addCandidate(human);
            Map<Class<?>, List<Worker>> candidates = hr.getCandidates();
            Optional<SecretaryImpl> optionalSecretary = director.chooseWorker(candidates, SecretaryImpl.class);


            optionalSecretary.ifPresent(s -> secretary = s);
        }
    }


}



