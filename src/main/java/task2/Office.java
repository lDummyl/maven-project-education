package task2;

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

    public void setWorker(Worker candidate) {
        if (candidate.getClass().equals(Manager.class)) {
            setManager((Manager) candidate);
        } else if (candidate.getClass().equals(Lawyer.class)) {
            setLawyer((Lawyer) candidate);
        } else if (candidate.getClass().equals(Guard.class)) {
            setGuard((Guard) candidate);
        } else if (candidate.getClass().equals(SecretaryImpl.class)) {
            setSecretary((SecretaryImpl) candidate);
        }
    }


    //претенденты идут по одному, когда их достаточно,
    // то директор принимает решение и берет одного в штат


    void invitePeople(Object human) {
        if (!(human instanceof Worker)) {
            throw new IllegalStateException("It's not worker");
        } else {
            this.hr.addCandidate(human);
            // FIXME: 22.11.2020 Остаётся unchecked cast
            Worker worker = this.director.chooseWorker(hr.getCandidates(), (Class<? extends Worker>) human.getClass());
            setWorker(worker);
        }
    }

    // TODO: 11/16/20 для всех одна дверь, нет двери для охраниников и для секретарей отдельно

}
