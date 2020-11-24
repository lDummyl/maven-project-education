package task2;

import java.util.function.Function;

public class Office {
    Worker secretary;
    Director director;
    Hr hr;
    Manager manager;
    Lawyer lawyer;
    Guard guard;


    public Office(Director director, Hr hr) {
        this.director = director;
        this.hr = hr;
    }

    public void setSecretary(Worker secretary) {
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

     void invitePeople(Object human) {
        if (!(human instanceof Worker)) {
            throw new IllegalStateException("It's not worker");
        } else {
            this.hr.addCandidate(human);
            Worker worker = this.director.chooseWorker(hr.getCandidates(), human.getClass());
        }

     }
    /* <T extends Worker> void invitePeople(T human) {
         this.hr.addCandidate(human);
         Worker worker = this.director.chooseWorker(hr.getCandidates(), human.getClass());
     }*/
    // FIXME: 22.11.2020 Остаётся unchecked cast
    // TODO: 23.11.2020 короче говоря нужно чтобы директор возвращал сразу кого надо и только когда надо, директор много работать не любит

    // TODO: 23.11.2020 там внизу в скобочках это называется downcast, чем его больше тем хуже,
    //  ищи спасение от него в дженериках(они почти только за тем и сделаны) тебе должно помочь видео и то что мы делали в candidateProvider
    //  ну если  станет не в моготу то глянь в ветку eWheat.


}

// TODO: 11/16/20 для всех одна дверь, нет двери для охраниников и для секретарей отдельно


