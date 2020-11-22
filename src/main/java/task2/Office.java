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

    // TODO: 23.11.2020 там внизу в скобочках это называется downcast, чем его больше тем хуже,
    //  ищи спасение от него в дженериках(они почти только за тем и сделаны) тебе должно помочь видео и то что мы делали в candidateProvider
    //  ну если  станет не в моготу то глянь в ветку eWheat.
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
            // TODO: 23.11.2020 короче говоря нужно чтобы директор возвращал сразу кого надо и только когда надо, директор много работать не любит
            Worker worker = this.director.chooseWorker(hr.getCandidates(), (Class<? extends Worker>) human.getClass());
            setWorker(worker);
        }
    }

    // TODO: 11/16/20 для всех одна дверь, нет двери для охраниников и для секретарей отдельно

}
