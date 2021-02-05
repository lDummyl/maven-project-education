package task2;

import task2.workers.*;

import java.util.Optional;


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

    void invitePeople(Object human) {
        if (!(human instanceof Worker)) {
            throw new IllegalStateException("It's not worker");
        } else {
            this.hr.addCandidateDet((Worker) human);
        }
        if (human instanceof Secretary) {
            Optional<SecretaryImpl> optionalSecretary = director.chooseWorker(this.hr.getCandidates(), SecretaryImpl.class);
            optionalSecretary.ifPresent(s -> secretary = s);
        } else if (human instanceof Guard) {
            Optional<Guard> optionalGuard = director.chooseWorker(this.hr.getCandidates(), Guard.class);
            optionalGuard.ifPresent(s -> guard = s);
        } else if (human instanceof Lawyer) {
            Optional<Lawyer> optionalLawyer = director.chooseWorker(this.hr.getCandidates(), Lawyer.class);
            optionalLawyer.ifPresent(s -> lawyer = s);
        } else if (human instanceof Manager) {
            Optional<Manager> optionalManager = director.chooseWorker(this.hr.getCandidates(), Manager.class);
            optionalManager.ifPresent(s -> manager = s);
        }
    }
}



