package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
	Accountant accountant;;

    String nameOffice;

	Director director = new Director(this);
	Hr hr = new Hr("Аделаида Марковна");

    public Office(){};

    public Office(String nameOffice){ this.nameOffice = nameOffice;};


	void invitePeople(Object human) {      //претенденты приходят по одному

        // TODO: 9/12/19 почему офис должен что-то решать? Ты где-то всетречал такие? Это пространстов в котором люди что-то длают, бизнес логики он содержать не должен.

		//	List<Secretary> currentCandidatesOfSecretaries = hr.considerAnyCandidate((WantAWork) human);  //создаем спсок текущих кандидатов и присваивам ему список от Hr с параметром human, который приведен к типу WantAWork
        //    List<Accountant> currentCandidatesOfAccountants = hr.considerAnyCandidate((WantAWork) human);

        System.out.println("director.choiceSecretaryMade - " + director.choiceSecretaryMade + "; director.choiceAccountantMade - " + director.choiceAccountantMade);
        hr.considerAnyCandidate(human, director.choiceSecretaryMade, director.choiceAccountantMade);

            // TODO: 9/12/19 то же самое

        secretary = director.chooseSecretary(hr.listSeekersOnSecretary);

            System.out.println("secretary (office) - " + secretary);

        accountant = director.chooseAccountant(hr.listSeekersOnAccountant);

        System.out.println("accountant (office) - " + accountant);



                // TODO: 9/12/19 то же самое, никаких if только вызовы методов передача в них аргументов из других методов, и на худой конец создание объектов, не более

  //         }
  //          numberOfCandidates++;
	}
}


