package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Office {

	Secretary secretary;
	Accountant accountant;
	int numberOfCandidates=0;

    String nameOffice;

	Director director = new Director(this);   //зачем здесь параметр this не оч понятно?
	Hr hr = new Hr("Аделаида Марковна");

    public Office(){};

    public Office(String nameOffice){ this.nameOffice = nameOffice;};


	void invitePeople(Object human) {      //претенденты приходят по одному

        // TODO: 9/12/19 почему офис должен что-то решать? Ты где-то всетречал такие? Это пространстов в котором люди что-то длают, бизнес логики он содержать не должен.
		if (human instanceof WantAWork) {      //с помощью оператора instanceof убеждаемся, что обьекты human может быть приведен типу(интерфейсу) WantAWork
			List<Secretary> currentCandidatesOfSecretaries = hr.considerCandidateSecretaries((WantAWork) human);  //создаем спсок текущих кандидатов и присваивам ему список от Hr с параметром human, который приведен к типу WantAWork
            List<Accountant> currentCandidatesOfAccountants = hr.considerCandidateAccountants((WantAWork) human);

        //    System.out.println("currentCandidatesOfSecretaries - " + currentCandidatesOfSecretaries);
        //    System.out.println("currentCandidatesOfAccountants - " + currentCandidatesOfAccountants);

            // TODO: 9/12/19 то же самое
 //           if(numberOfCandidates>=27) {          // только с помощью этого искусственного костыля получется решить эту задачу.. понимаю, что если изменить кол-во laborMarket тест сразу посыпеться =(
                secretary = director.chooseSecretary(currentCandidatesOfSecretaries);
                if(secretary!=null)
                    secretary.office = this;

                accountant = director.chooseAccountant(currentCandidatesOfAccountants);
                if(accountant!=null)
                    accountant.office = this;

                // TODO: 9/12/19 то же самое, никаких if только вызовы методов передача в них аргументов из других методов, и на худой конец создание объектов, не более

  //         }
  //          numberOfCandidates++;
		}
	}
}


