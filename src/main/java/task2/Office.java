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


	void invitePeople(Object human) {

        hr.considerAnyCandidate(human, director.choiceSecretaryMade, director.choiceAccountantMade);

        director.chooseSecretary(hr.listSeekersOnSecretary);

        director.chooseAccountant(hr.listSeekersOnAccountant);

        // TODO: 9/12/19 то же самое, никаких if только вызовы методов передача в них аргументов из других методов, и на худой конец создание объектов, не более

	}

	public Secretary getSecretary(){
	    return secretary;
    }

    public void setSecretary(Secretary secretary){
	    this.secretary = secretary;
    }

    public Accountant getAccountant(){
        return accountant;
    }

    public void setAccountant(Accountant accountant){
        this.accountant = accountant;
    }
}


