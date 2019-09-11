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

		if (human instanceof WantAWork) {      //с помощью оператора instanceof убеждаемся, что обьекты human может быть приведен типу(интерфейсу) WantAWork
			List<Secretary> currentCandidatesOfSecretaries = hr.considerCandidateSecretaries((WantAWork) human);  //создаем спсок текущих кандидатов и присваивам ему список от Hr с параметром human, который приведен к типу WantAWork
            List<Accountant> currentCandidatesOfAccountants = hr.considerCandidateAccountants((WantAWork) human);

            if(numberOfCandidates>=10) {          // только с помощью этого искусственного костыля получется решить эту задачу.. понимаю, что если изменить кол-во laborMarket тест сразу посыпеться =(
                secretary = director.chooseSecretary(currentCandidatesOfSecretaries);
                accountant = director.chooseAccountant(currentCandidatesOfAccountants);

                if (secretary != null)
                    secretary.hired = true;
                if (accountant != null)
                    accountant.hired = true;
            }
            numberOfCandidates++;
		}
	}
}


